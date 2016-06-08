/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path='../d.ts/UzaConverter.d.ts' />





module DBB {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export class DBB0320001_Events {
        public static onLoad(): string {
            return "onLoad";
        }

        public static get onClick_btnForRirekiFirst(): string {
            return "onClick_btnForRirekiFirst";
        }
        public static get onClick_btnForRirekiSecond(): string {
            return "onClick_btnForRirekiSecond";
        }
        public static get onClick_rireki(): string {
            return "onClick_rireki";
        }
        public static get onClick_loadFukakonkyo(): string {
            return "onClick_loadFukakonkyo";
        }
        public static get onClick_btnSetaiinShotoku(): string {
            return "onClick_btnSetaiinShotoku";
        }
        public static get onClick_btnTokucho(): string {
            return "onClick_btnTokucho";
        }
        public static get onClick_btnGenmen(): string {
            return "onClick_btnGenmen";
        }
        public static get onClick_MaeHikaku(): string {
            return "onClick_MaeHikaku";
        }
        public static get onSelect_FukaRireki(): string {
            return "onSelect_FukaRireki";
        }
        public static get onAfterSelect_FukaRireki(): string {
            return "onAfterSelect_FukaRireki";
        }

    }

    export class DBB0320001_Control {

       


        public static EventPanel() : UZA.Panel {
            return new UZA.Panel("EventPanel");
        }
        
        public static btnForRirekiFirst() : UZA.Button {
            return new UZA.Button("btnForRirekiFirst");
        }
        
        public static btnForRirekiSecond() : UZA.Button {
            return new UZA.Button("btnForRirekiSecond");
        }
        
        public static KihonJoho() : UZA.Panel {
            return new UZA.Panel("KihonJoho");
        }
        
        public static FukaShokaiControl() : UZA.Panel {
            return new UZA.Panel("FukaShokaiControl");
        }
        
        public static txtChoteiNendo() : UZA.TextBoxFlexibleYear {
            return new UZA.TextBoxFlexibleYear("txtChoteiNendo");
        }
        
        public static txtKoseiM() : UZA.TextBox {
            return new UZA.TextBox("txtKoseiM");
        }
        
        public static txtKoseiYMD() : UZA.TextBoxFlexibleDate {
            return new UZA.TextBoxFlexibleDate("txtKoseiYMD");
        }
        
        public static txtKoseiTime() : UZA.TextBoxTime {
            return new UZA.TextBoxTime("txtKoseiTime");
        }
        
        public static btnRirekiHyoji() : UZA.Button {
            return new UZA.Button("btnRirekiHyoji");
        }
        
        public static btnFukakonkyoKiwari() : UZA.Button {
            return new UZA.Button("btnFukakonkyoKiwari");
        }
        
        public static btnSetaiinShotoku() : UZA.Button {
            return new UZA.Button("btnSetaiinShotoku");
        }
        
        public static btnTokucho() : UZA.Button {
            return new UZA.Button("btnTokucho");
        }
        
        public static btnGemmen() : UZA.Button {
            return new UZA.Button("btnGemmen");
        }
        
        public static FukaRirekiAllPanel() : UZA.Panel {
            return new UZA.Panel("FukaRirekiAllPanel");
        }
        
        public static lblMode() : UZA.Label {
            return new UZA.Label("lblMode");
        }
        
        public static FukaRirekiPanel() : UZA.Panel {
            return new UZA.Panel("FukaRirekiPanel");
        }
        
        public static txtFukaNendoFukaRireki() : UZA.TextBoxFlexibleYear {
            return new UZA.TextBoxFlexibleYear("txtFukaNendoFukaRireki");
        }
        
        public static dgFukaRirekiFukaRireki() : UZA.DataGrid {
            return new UZA.DataGrid("dgFukaRirekiFukaRireki");
        }
        
        public static FukakonkyoAndKiwari() : UZA.Panel {
            return new UZA.Panel("FukakonkyoAndKiwari");
        }
        
        public static tblFukaKonkyo() : UZA.TablePanel {
            return new UZA.TablePanel("tblFukaKonkyo");
        }
        
        public static celFukaKonkyo() : UZA.TableCell {
            return new UZA.TableCell("celFukaKonkyo");
        }
        
        public static tblFukakonkyoMeisai() : UZA.TablePanel {
            return new UZA.TablePanel("tblFukakonkyoMeisai");
        }
        
        public static celFukashokaiKonkyo() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo");
        }
        
        public static lblFukakonkyoMidashi() : UZA.Label {
            return new UZA.Label("lblFukakonkyoMidashi");
        }
        
        public static celFukashokaiKonkyo11() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo11");
        }
        
        public static lblFukakonkyo11() : UZA.Label {
            return new UZA.Label("lblFukakonkyo11");
        }
        
        public static celFukashokaiKonkyo21() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo21");
        }
        
        public static lblFukakijunYMD() : UZA.Label {
            return new UZA.Label("lblFukakijunYMD");
        }
        
        public static celFukashokaiKonkyo31() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo31");
        }
        
        public static lblHonninKazei() : UZA.Label {
            return new UZA.Label("lblHonninKazei");
        }
        
        public static lblZenHokenryoDankai() : UZA.Label {
            return new UZA.Label("lblZenHokenryoDankai");
        }
        
        public static celFukashokaiKonkyo68() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo68");
        }
        
        public static lblHonninKazeiValue() : UZA.Label {
            return new UZA.Label("lblHonninKazeiValue");
        }
        
        public static lblZenHokenryoDankaiValue() : UZA.Label {
            return new UZA.Label("lblZenHokenryoDankaiValue");
        }
        
        public static celFukashokaiKonkyo12() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo12");
        }
        
        public static lblFukakonkyo12() : UZA.Label {
            return new UZA.Label("lblFukakonkyo12");
        }
        
        public static celFukashokaiKonkyo22() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo22");
        }
        
        public static lblShikakuShutokuYMD() : UZA.Label {
            return new UZA.Label("lblShikakuShutokuYMD");
        }
        
        public static celFukashokaiKonkyo32() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo32");
        }
        
        public static lblSetaiKazei() : UZA.Label {
            return new UZA.Label("lblSetaiKazei");
        }
        
        public static lblZenHokenryoritsu() : UZA.Label {
            return new UZA.Label("lblZenHokenryoritsu");
        }
        
        public static celFukashokaiKonkyo69() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo69");
        }
        
        public static lblSetaiKazeiValue() : UZA.Label {
            return new UZA.Label("lblSetaiKazeiValue");
        }
        
        public static lblZenHokenryoritsuValue() : UZA.Label {
            return new UZA.Label("lblZenHokenryoritsuValue");
        }
        
        public static celFukashokaiKonkyo13() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo13");
        }
        
        public static lblFukakonkyo13() : UZA.Label {
            return new UZA.Label("lblFukakonkyo13");
        }
        
        public static celFukashokaiKonkyo23() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo23");
        }
        
        public static lblShikakuSoshitsuYMD() : UZA.Label {
            return new UZA.Label("lblShikakuSoshitsuYMD");
        }
        
        public static celFukashokaiKonkyo33() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo33");
        }
        
        public static lblShotokuSum() : UZA.Label {
            return new UZA.Label("lblShotokuSum");
        }
        
        public static lblZenNengakuHokenryo() : UZA.Label {
            return new UZA.Label("lblZenNengakuHokenryo");
        }
        
        public static celFukashokaiKonkyo70() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo70");
        }
        
        public static lblShotokuSumValue() : UZA.Label {
            return new UZA.Label("lblShotokuSumValue");
        }
        
        public static lblZenNengakuHokenryoValue() : UZA.Label {
            return new UZA.Label("lblZenNengakuHokenryoValue");
        }
        
        public static celFukashokaiKonkyo14() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo14");
        }
        
        public static lblFukakonkyo14() : UZA.Label {
            return new UZA.Label("lblFukakonkyo14");
        }
        
        public static celFukashokaiKonkyo24() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo24");
        }
        
        public static lblSeihoKaishiYMD() : UZA.Label {
            return new UZA.Label("lblSeihoKaishiYMD");
        }
        
        public static celFukashokaiKonkyo34() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo34");
        }
        
        public static lblNenkinShunyu() : UZA.Label {
            return new UZA.Label("lblNenkinShunyu");
        }
        
        public static celFukashokaiKonkyo71() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo71");
        }
        
        public static lblNenkinShunyuValue() : UZA.Label {
            return new UZA.Label("lblNenkinShunyuValue");
        }
        
        public static celFukashokaiKonkyo15() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo15");
        }
        
        public static lblFukakonkyo15() : UZA.Label {
            return new UZA.Label("lblFukakonkyo15");
        }
        
        public static celFukashokaiKonkyo25() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo25");
        }
        
        public static lblSeihoShuryoYMD() : UZA.Label {
            return new UZA.Label("lblSeihoShuryoYMD");
        }
        
        public static celFukashokaiKonkyo35() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo35");
        }
        
        public static lblHokenryoDankai() : UZA.Label {
            return new UZA.Label("lblHokenryoDankai");
        }
        
        public static celFukashokaiKonkyo72() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo72");
        }
        
        public static lblHokenryoDankaiValue() : UZA.Label {
            return new UZA.Label("lblHokenryoDankaiValue");
        }
        
        public static celFukashokaiKonkyo16() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo16");
        }
        
        public static lblFukakonkyo16() : UZA.Label {
            return new UZA.Label("lblFukakonkyo16");
        }
        
        public static celFukashokaiKonkyo26() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo26");
        }
        
        public static lblRonenKaishiYMD() : UZA.Label {
            return new UZA.Label("lblRonenKaishiYMD");
        }
        
        public static celFukashokaiKonkyo36() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo36");
        }
        
        public static lbldamy1() : UZA.Label {
            return new UZA.Label("lbldamy1");
        }
        
        public static celFukashokaiKonkyo73() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo73");
        }
        
        public static celFukashokaiKonkyo17() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo17");
        }
        
        public static lblFukakonkyo17() : UZA.Label {
            return new UZA.Label("lblFukakonkyo17");
        }
        
        public static celFukashokaiKonkyo27() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo27");
        }
        
        public static lblRonenShuryoYMD() : UZA.Label {
            return new UZA.Label("lblRonenShuryoYMD");
        }
        
        public static celFukashokaiKonkyo61() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo61");
        }
        
        public static celFukashokaiKonkyo74() : UZA.TableCell {
            return new UZA.TableCell("celFukashokaiKonkyo74");
        }
        
        public static lblDamy() : UZA.Label {
            return new UZA.Label("lblDamy");
        }
        
        public static txtZanteiKeisanjoHokenryoGaku() : UZA.TextBoxNum {
            return new UZA.TextBoxNum("txtZanteiKeisanjoHokenryoGaku");
        }
        
        public static txtZanteiGemmenGaku() : UZA.TextBoxNum {
            return new UZA.TextBoxNum("txtZanteiGemmenGaku");
        }
        
        public static txtZanteiHokenryoGaku() : UZA.TextBoxNum {
            return new UZA.TextBoxNum("txtZanteiHokenryoGaku");
        }
        
        public static celKiwari() : UZA.TableCell {
            return new UZA.TableCell("celKiwari");
        }
        
        public static celKikan() : UZA.TableCell {
            return new UZA.TableCell("celKikan");
        }
        
        public static Kikan() : UZA.Panel {
            return new UZA.Panel("Kikan");
        }
        
        public static tblKikan1() : UZA.TablePanel {
            return new UZA.TablePanel("tblKikan1");
        }
        
        public static cellFukaShokaiData1() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData1");
        }
        
        public static lblKikan() : UZA.Label {
            return new UZA.Label("lblKikan");
        }
        
        public static cellFukaShokaiData2() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData2");
        }
        
        public static lblTsukiSu() : UZA.Label {
            return new UZA.Label("lblTsukiSu");
        }
        
        public static cellFukaShokaiData3() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData3");
        }
        
        public static lblShotokuDankai() : UZA.Label {
            return new UZA.Label("lblShotokuDankai");
        }
        
        public static cellFukaShokaiData10() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData10");
        }
        
        public static lblHokenryoritsu() : UZA.Label {
            return new UZA.Label("lblHokenryoritsu");
        }
        
        public static cellFukaShokaiData11() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData11");
        }
        
        public static lblHokenryoSansyutsu() : UZA.Label {
            return new UZA.Label("lblHokenryoSansyutsu");
        }
        
        public static cellFukaShokaiData12() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData12");
        }
        
        public static lblHokenryo() : UZA.Label {
            return new UZA.Label("lblHokenryo");
        }
        
        public static cellFukaShokaiData4() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData4");
        }
        
        public static lblKikan1() : UZA.Label {
            return new UZA.Label("lblKikan1");
        }
        
        public static cellFukaShokaiData5() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData5");
        }
        
        public static lblTsukiSu1() : UZA.Label {
            return new UZA.Label("lblTsukiSu1");
        }
        
        public static cellFukaShokaiData6() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData6");
        }
        
        public static lblHokenryoDankai1() : UZA.Label {
            return new UZA.Label("lblHokenryoDankai1");
        }
        
        public static cellFukaShokaiData13() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData13");
        }
        
        public static lblHokenryoritsu1() : UZA.Label {
            return new UZA.Label("lblHokenryoritsu1");
        }
        
        public static cellFukaShokaiData14() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData14");
        }
        
        public static lblHokenryoSansyutsu1() : UZA.Label {
            return new UZA.Label("lblHokenryoSansyutsu1");
        }
        
        public static cellFukaShokaiData15() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData15");
        }
        
        public static lblHokenryo1() : UZA.Label {
            return new UZA.Label("lblHokenryo1");
        }
        
        public static tblKikan2() : UZA.TablePanel {
            return new UZA.TablePanel("tblKikan2");
        }
        
        public static cellFukaShokaiData16() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData16");
        }
        
        public static lblKikan2() : UZA.Label {
            return new UZA.Label("lblKikan2");
        }
        
        public static cellFukaShokaiData17() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData17");
        }
        
        public static lblTsukiSu2() : UZA.Label {
            return new UZA.Label("lblTsukiSu2");
        }
        
        public static cellFukaShokaiData18() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData18");
        }
        
        public static lblHokenryoDankai2() : UZA.Label {
            return new UZA.Label("lblHokenryoDankai2");
        }
        
        public static cellFukaShokaiData19() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData19");
        }
        
        public static lblHokenryoritsu2() : UZA.Label {
            return new UZA.Label("lblHokenryoritsu2");
        }
        
        public static cellFukaShokaiData20() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData20");
        }
        
        public static lblHokenryoSansyutsu2() : UZA.Label {
            return new UZA.Label("lblHokenryoSansyutsu2");
        }
        
        public static cellFukaShokaiData21() : UZA.TableCell {
            return new UZA.TableCell("cellFukaShokaiData21");
        }
        
        public static lblHokenryo2() : UZA.Label {
            return new UZA.Label("lblHokenryo2");
        }
        
        public static FukakonkyoNengaku() : UZA.Panel {
            return new UZA.Panel("FukakonkyoNengaku");
        }
        
        public static KakuteiNengaku() : UZA.Panel {
            return new UZA.Panel("KakuteiNengaku");
        }
        
        public static txtKeisanjoNenkanHokenryoGaku() : UZA.TextBoxNum {
            return new UZA.TextBoxNum("txtKeisanjoNenkanHokenryoGaku");
        }
        
        public static txtGemmenGaku() : UZA.TextBoxNum {
            return new UZA.TextBoxNum("txtGemmenGaku");
        }
        
        public static txtNenkanHokenryoGaku() : UZA.TextBoxNum {
            return new UZA.TextBoxNum("txtNenkanHokenryoGaku");
        }
        
        public static celChoteiJiyu() : UZA.TableCell {
            return new UZA.TableCell("celChoteiJiyu");
        }
        
        public static txtFukashokaiChoteiJiyu1() : UZA.TextBox {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu1");
        }
        
        public static txtFukashokaiChoteiJiyu2() : UZA.TextBox {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu2");
        }
        
        public static txtFukashokaiChoteiJiyu3() : UZA.TextBox {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu3");
        }
        
        public static txtFukashokaiChoteiJiyu4() : UZA.TextBox {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu4");
        }
        

    }
}
