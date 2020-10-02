#include <stdio.h>
#include <stdbool.h>
#define ROWS 9
#define COL 9

void print_soduko_square();


typedef struct {
	int number;
	bool start_number; 
}Suduko_Numbers;

//Only for testing
Suduko_Numbers soduko_square[9][9] = {
{{8, true},{0, false},{0, false}, {0, false},{0, false},{0, false},{0, false},{0, false},{0, false}},
{{0, false},{0, false},{3, true}, {6, true},{0, false},{0, false},{0, false},{0, false},{0, false}},
{{0, false},{7, true},{0, false}, {0, false},{9, true},{0, false},{2, true},{0, false},{0, false}},
{{0, false},{5, true},{0, false}, {0, false},{0, false},{7, true},{0, false},{0, false},{0, false}},
{{0, false},{0, false},{0, false}, {0, false},{4, true},{5, true},{7, true},{0, false},{0, false}},
{{0, false},{0, false},{0, false}, {1, true},{0, false},{0, false},{0, false},{3, true},{0, false}},
{{0, false},{0, false},{1, true}, {0, false},{0, false},{0, false},{0, false},{6, true},{8, true}},
{{0, false},{0, false},{8, true}, {5, true},{0, false},{0, false},{0, false},{1, true},{0, false}},
{{0, false},{9, true},{0, false}, {0, false},{0, false},{0, false},{4, true},{0, false},{0, false}},
};

int main(int argc, char const *argv[])
{
	print_soduko_square();
	return 0;
}


void print_soduko_square()
{
	for(int i = 0; i < ROWS; i++)
	{
		for(int j = 0; j < COL; j++)
		{
			printf("%d ", soduko_square[i][j].number);
		}
		printf("%s\n", "");
	}
}