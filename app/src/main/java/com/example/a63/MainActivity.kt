package com.example.a63

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a63.ui.theme.A63Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A63Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        class Solution {
            fun solution(X: String, Y: String): String {
                var answer: String = ""
                //x,y의 임의의자리에서 공통으로 나타나는 정수 k들을 이용하여 만들수 있는 가장 큰정수
                //x,y 짝궁이 존재x -1 return
                //x,y 짝궁이 0으로만 구성되어있음 0 return

                //x,y에서 공통된 값이있다면 그값을 배열에 저장
                //저장된 배열값으로 큰 정수로 만들고 리턴
                var x = X.toMutableList()
                var y = Y.toMutableList()
                var z = mutableListOf<Char>() // 공통된 값 배열
                while(!x.isEmpty()){
                    if(y.contains(x.first())){
                        z.add(x.first())
                        y.removeAt(y.indexOf(x.first()))
                    }
                    x.removeFirst()
                }

                if(z.isEmpty()) return "-1" // 짝궁이 존재 x

                z.sortDescending() // 내림차순으로 정렬

                if(z.first()=='0') return "0"//내림차순인데 첫인자가 0이면 값이 0

                answer = StringBuilder().append(z.toCharArray()).toString()

                return answer
            }
        }
        var a = Solution()
        a.solution("100","2345")//-1
        a.solution("100","203045")//0
        a.solution("100","1223450")//10
        a.solution("12321","42531")//321
        a.solution("5525","1255")//552
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    A63Theme {
        Greeting("Android")
    }
}