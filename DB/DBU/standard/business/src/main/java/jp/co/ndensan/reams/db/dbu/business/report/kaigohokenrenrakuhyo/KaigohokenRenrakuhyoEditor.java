/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo;

import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoReportSource;

/**
 * 介護保険連絡票のEditorクラスです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
public class KaigohokenRenrakuhyoEditor implements IKaigohokenRenrakuhyoEditor {

    private final KaigohokenRenrakuhyo renrakuhyo;

    /**
     * コンストラクタです。
     *
     * @param renrakuhyo 一覧表証発行者Entityリストです
     */
    public KaigohokenRenrakuhyoEditor(KaigohokenRenrakuhyo renrakuhyo) {
        this.renrakuhyo = renrakuhyo;
    }

    @Override
    public KaigohokenRenrakuhyoReportSource edit(KaigohokenRenrakuhyoReportSource source) {
        return editBody(source);
    }

    private KaigohokenRenrakuhyoReportSource editBody(KaigohokenRenrakuhyoReportSource source) {
        source.sakuseiDate = renrakuhyo.get作成年月日();
        source.hihokenshaNo = renrakuhyo.get被保険者番号();
        source.shimeiFurigana = renrakuhyo.get氏名フリガナ();
        source.shimei = renrakuhyo.get被保険者氏名();
        source.birthDay = renrakuhyo.get生年月日();
        source.seibetsu = renrakuhyo.get性別();
        source.jusho = renrakuhyo.get住所();
        source.telNo = renrakuhyo.get電話番号();
        source.yokaigoCheck = renrakuhyo.get要介護チェック();
        source.yokaigoDankai = renrakuhyo.get要介護度段階();
        source.yoshienCheck = renrakuhyo.get要支援チェック();
        source.yoshienDankai = renrakuhyo.get要支援段階();
        source.higaitoCheck = renrakuhyo.get認定非該当チェック();
        source.mininteiCheck = renrakuhyo.get未認定チェック();
        source.ninteiDate = renrakuhyo.get認定年月日();
        source.kyufuGendogakuKisaiCheck = renrakuhyo.get給付減額の記載チェック();
        source.kyufuGendogaku = renrakuhyo.get給付減額();
        source.kyojuhiCheck = renrakuhyo.get居住費の負担限度日額記載チェック();
        source.koshitsu1Check = renrakuhyo.get第1段階_個室チェック();
        source.koshitsu1Kingaku = renrakuhyo.get第1段階_個室金額();
        source.koshitsu2Check = renrakuhyo.get第2段階_個室チェック();
        source.koshitsu2Kingaku = renrakuhyo.get第2段階_個室金額();
        source.koshitsu3Check = renrakuhyo.get第3段階_個室チェック();
        source.koshitsu3Kingaku = renrakuhyo.get第3段階_個室金額();
        source.koshitsuKijunCheck = renrakuhyo.get基準額_個室チェック();
        source.koshitsuKijunKingaku = renrakuhyo.get基準額_個室金額();
        source.junKoshitsu1Check = renrakuhyo.get第1段階_準個室チェック();
        source.junKoshitsu1Kingaku = renrakuhyo.get第1段階_準個室金額();
        source.junKoshitsu2Check = renrakuhyo.get第2段階_準個室チェック();
        source.junKoshitsu2Kingaku = renrakuhyo.get第2段階_準個室金額();
        source.junKoshitsu3Check = renrakuhyo.get第3段階_準個室チェック();
        source.junKoshitsu3Kingaku = renrakuhyo.get第3段階_準個室金額();
        source.junKoshitsuKijunCheck = renrakuhyo.get基準額_準個室チェック();
        source.junKoshitsuKijunKingaku = renrakuhyo.get基準額_準個室金額();
        source.tokuyo1Check = renrakuhyo.get第1段階_従来型個室_特養チェック();
        source.tokuyo1Kingaku = renrakuhyo.get第1段階_従来型個室_特養金額();
        source.tokuyo2Check = renrakuhyo.get第2段階_従来型個室_特養チェック();
        source.tokuyo2Kingaku = renrakuhyo.get第2段階_従来型個室_特養金額();
        source.tokuyo3Check = renrakuhyo.get第3段階_従来型個室_特養チェック();
        source.tokuyo3Kingaku = renrakuhyo.get第3段階_従来型個室_特養金額();
        source.tokuyoKijunCheck = renrakuhyo.get基準額_従来型個室_特養チェック();
        source.tokuyoKijunKingaku = renrakuhyo.get基準額_従来型個室_特養金額();
        source.roken1Check = renrakuhyo.get第1段階_従来型個室_老健療養型チェック();
        source.roken1Kingaku = renrakuhyo.get第1段階_従来型個室_老健療養型金額();
        source.roken2Check = renrakuhyo.get第2段階_従来型個室_老健療養型チェック();
        source.roken2Kingaku = renrakuhyo.get第2段階_従来型個室_老健療養型金額();
        source.roken3Check = renrakuhyo.get第3段階_従来型個室_老健療養型チェック();
        source.roken3Kingaku = renrakuhyo.get第3段階_従来型個室_老健療養型金額();
        source.rokenKijunCheck = renrakuhyo.get基準額_従来型個室_老健療養型チェック();
        source.rokenKijunKingaku = renrakuhyo.get基準額_従来型個室_老健療養型金額();
        source.tashoshitsu1Check = renrakuhyo.get第1段階_多床室チェック();
        source.tashoshitsu1Kingaku = renrakuhyo.get第1段階_多床室金額();
        source.tashoshitsu2Check = renrakuhyo.get第2段階_多床室チェック();
        source.tashoshitsu2Kingaku = renrakuhyo.get第2段階_多床室金額();
        source.tashoshitsu3Check = renrakuhyo.get第3段階_多床室チェック();
        source.tashoshitsu3Kingaku = renrakuhyo.get第3段階_多床室金額();
        source.tashoshitsuKijunCheck = renrakuhyo.get基準額_多床室チェック();
        source.tashoshitsuKijunKingaku = renrakuhyo.get基準額_多床室金額();
        source.shokuhiCheck = renrakuhyo.get食費負担限度額記載チェック();
        source.shokuhi1Check = renrakuhyo.get食費チェック1();
        source.shokuhi1Kingaku = renrakuhyo.get食費金額1();
        source.shokuhi2Check = renrakuhyo.get食費チェック2();
        source.shokuhi2Kingaku = renrakuhyo.get食費金額2();
        source.shokuhi3Check = renrakuhyo.get食費チェック3();
        source.shokuhi3Kingaku = renrakuhyo.get食費金額3();
        source.shokuhi4Check = renrakuhyo.get食費チェック4();
        source.shokuhi4Kingaku = renrakuhyo.get食費金額4();
        source.shokuhiOtherKingaku = renrakuhyo.get食費金額その他();
        source.kogakuKaigoCheck = renrakuhyo.get高額介護サービス費の支給による自己負担上限月額記載チェック();
        source.kogakuKaigo1Check = renrakuhyo.get高額介護チェック1();
        source.kogakuKaigo1Kingaku = renrakuhyo.get高額介護金額1();
        source.kogakuKaigo2Check = renrakuhyo.get高額介護チェック２();
        source.kogakuKaigo2Kingaku = renrakuhyo.get高額介護金額2();
        source.kogakuKaigo3Check = renrakuhyo.get高額介護チェック3();
        source.kogakuKaigo3Kingaku = renrakuhyo.get高額介護金額3();
        source.kogakuKaigo4Check = renrakuhyo.get高額介護チェック4();
        source.kogakuKaigo4Kingaku = renrakuhyo.get高額介護金額4();
        source.kogakuKaigoOtherKingaku = renrakuhyo.get高額介護金額その他();
        source.kaigoHokenryoCheck = renrakuhyo.get介護保険料記載チェック();
        source.kaigoHokenryo1Check = renrakuhyo.get保険料チェック1();
        source.kaigoHokenryo1Kingaku = renrakuhyo.get保険料金額1();
        source.kaigoHokenryo2Check = renrakuhyo.get保険料チェック2();
        source.kaigoHokenryo2Kingaku = renrakuhyo.get保険料金額2();
        source.kaigoHokenryo3Check = renrakuhyo.get保険料チェック3();
        source.kaigoHokenryo3Kingaku = renrakuhyo.get保険料金額3();
        source.kaigoHokenryo4Check = renrakuhyo.get保険料チェック4();
        source.kaigoHokenryo4Kingaku = renrakuhyo.get保険料金額4();
        source.kaigoHokenryo5Check = renrakuhyo.get保険料チェック5();
        source.kaigoHokenryo5Kingaku = renrakuhyo.get保険料金額5();
        source.kaigoHokenryo6Check = renrakuhyo.get保険料チェック6();
        source.kaigoHokenryo6Kingaku = renrakuhyo.get保険料金額6();
        source.kaigoHokenryo7Check = renrakuhyo.get保険料チェック7();
        source.kaigoHokenryo7Kingaku = renrakuhyo.get保険料金額7();
        source.kaigoHokenryo8Check = renrakuhyo.get保険料チェック8();
        source.kaigoHokenryo8Kingaku = renrakuhyo.get保険料金額8();
        source.kaigoHokenryo9Check = renrakuhyo.get保険料チェック9();
        source.kaigoHokenryo9Kingaku = renrakuhyo.get保険料金額9();
        source.kaigoHokenryo10Check = renrakuhyo.get保険料チェック10();
        source.kaigoHokenryo10Kingaku = renrakuhyo.get保険料金額10();
        source.kaigoHokenryo11Check = renrakuhyo.get保険料チェック11();
        source.kaigoHokenryo11Kingaku = renrakuhyo.get保険料金額11();
        source.kaigoHokenryoOtherCheck = renrakuhyo.get保険料チェックその他();
        source.kaigoHokenryoOtherKingaku = renrakuhyo.get保険料金額その他();
        source.hokenryoDankai1 = renrakuhyo.get保険料段階1();
        source.hokenryoDankai2 = renrakuhyo.get保険料段階2();
        source.hokenryoDankai3 = renrakuhyo.get保険料段階3();
        source.hokenryoDankai4 = renrakuhyo.get保険料段階4();
        source.hokenryoDankai5 = renrakuhyo.get保険料段階5();
        source.hokenryoDankai6 = renrakuhyo.get保険料段階6();
        source.hokenryoDankai7 = renrakuhyo.get保険料段階7();
        source.hokenryoDankai8 = renrakuhyo.get保険料段階8();
        source.hokenryoDankai9 = renrakuhyo.get保険料段階9();
        source.hokenryoDankai10 = renrakuhyo.get保険料段階10();
        source.hokenryoDankai11 = renrakuhyo.get保険料段階11();
        source.hokenryoDankai12 = renrakuhyo.get保険料段階12();
        source.biko = renrakuhyo.get備考();
        source.hokenryoDankaiUp1 = renrakuhyo.get保険料段階1_上段();
        source.hokenryoDankaiUp2 = renrakuhyo.get保険料段階2_上段();
        source.hokenryoDankaiUp3 = renrakuhyo.get保険料段階3_上段();
        source.hokenryoDankaiUp4 = renrakuhyo.get保険料段階4_上段();
        source.hokenryoDankaiUp5 = renrakuhyo.get保険料段階5_上段();
        source.hokenryoDankaiUp6 = renrakuhyo.get保険料段階6_上段();
        source.hokenryoDankaiUp7 = renrakuhyo.get保険料段階7_上段();
        source.hokenryoDankaiUp8 = renrakuhyo.get保険料段階8_上段();
        source.hokenryoDankaiUp9 = renrakuhyo.get保険料段階9_上段();
        source.hokenryoDankaiUp10 = renrakuhyo.get保険料段階10_上段();
        source.hokenryoDankaiUp11 = renrakuhyo.get保険料段階11_上段();
        source.hokenryoDankaiUp12 = renrakuhyo.get保険料段階12_上段();
        source.hokenryoDankaiDown1 = renrakuhyo.get保険料段階1_下段();
        source.hokenryoDankaiDown2 = renrakuhyo.get保険料段階2_下段();
        source.hokenryoDankaiDown3 = renrakuhyo.get保険料段階3_下段();
        source.hokenryoDankaiDown4 = renrakuhyo.get保険料段階4_下段();
        source.hokenryoDankaiDown5 = renrakuhyo.get保険料段階5_下段();
        source.hokenryoDankaiDown6 = renrakuhyo.get保険料段階6_下段();
        source.hokenryoDankaiDown7 = renrakuhyo.get保険料段階7_下段();
        source.hokenryoDankaiDown8 = renrakuhyo.get保険料段階8_下段();
        source.hokenryoDankaiDown9 = renrakuhyo.get保険料段階9_下段();
        source.hokenryoDankaiDown10 = renrakuhyo.get保険料段階10_下段();
        source.hokenryoDankaiDown11 = renrakuhyo.get保険料段階11_下段();
        source.hokenryoDankaiDown12 = renrakuhyo.get保険料段階12_下段();
        return source;
    }
}
