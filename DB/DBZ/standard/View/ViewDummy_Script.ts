/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

// モジュール部分は業務コードとする。
module xxx {

    export class ViewDummy_Script {

        public static bindEvents() {
            /*
            イベントでの動作を登録するには以下のように記述する
            Uz.GyomuJSHelper.registOriginalEvent(dummy_Events.[イベント名](), (control: Uz._ViewControl) => {

                // コントロールのプロパティ取得
                // var fuga: string = [親DivID].[コントロールのfieldName]().[プロパティ名];

                // コントロールのプロパティ設定
                // [親DivID].[コントロールのfieldName]().[プロパティ名] = [設定値];

                // モード変更
                // [親DivID].[共有子DivのfieldName]().[共有子Divのモード種別]().[共有子Divのモード設定値]();

            });
            */

        }

    }
}

xxx.ViewDummy_Script.bindEvents();
