/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource;

/**
 * 介護保険連絡票_実質負担軽減者用のEditorです。
 *
 * @reamsid_L DBU-1290-060 wangrenze
 */
public class KaigohokenRenrakuhyoJisshitsuFutanEditor implements IKaigohokenRenrakuhyoJisshitsuFutanEditor {

    private final KaigohokenRenrakuhyoJisshitsuFutan jisshitsufutan;

    /**
     * インスタンスを生成します。
     *
     * @param jisshitsufutan {@link KaigohokenRenrakuhyoJisshitsuFutan}
     */
    protected KaigohokenRenrakuhyoJisshitsuFutanEditor(KaigohokenRenrakuhyoJisshitsuFutan jisshitsufutan) {
        this.jisshitsufutan = jisshitsufutan;
    }

    @Override
    public KaigohokenRenrakuhyoJisshitsuFutanReportSource edit(jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource source) {

        source.sakuseiDate = jisshitsufutan.get作成年月日();
        source.hihokenshaNo = jisshitsufutan.get被保険者番号();
        source.shimeiFurigana = jisshitsufutan.get氏名フリガナ();
        source.shimei = jisshitsufutan.get被保険者氏名();
        source.birthDay = jisshitsufutan.get生年月日();
        source.seibetsu = jisshitsufutan.get性別();
        source.jusho = jisshitsufutan.get住所();
        source.telNo = jisshitsufutan.get電話番号();
        source.yokaigoCheck = jisshitsufutan.get要介護チェック();
        source.yokaigoDankai = jisshitsufutan.get要介護度段階();
        source.yoshienCheck = jisshitsufutan.get要支援チェック();
        source.yoshienDankai = jisshitsufutan.get要支援段階();
        source.higaitoCheck = jisshitsufutan.get認定非該当チェック();
        source.mininteiCheck = jisshitsufutan.get未認定チェック();
        source.ninteiDate = jisshitsufutan.get認定年月日();
        source.kyufuGendogakuKisaiCheck = jisshitsufutan.get給付減額の記載チェック();
        source.kyufuGendogaku = jisshitsufutan.get給付減額();
        source.kyojuhiCheck = jisshitsufutan.get居住費の負担限度日額記載チェック();
        source.koshitsu1Check = jisshitsufutan.get第1段階_個室チェック();
        source.koshitsu1Kingaku = jisshitsufutan.get第1段階_個室金額();
        source.koshitsu2Check = jisshitsufutan.get第2段階_個室チェック();
        source.koshitsu2Kingaku = jisshitsufutan.get第2段階_個室金額();
        source.koshitsu3Check = jisshitsufutan.get第3段階_個室チェック();
        source.koshitsu3Kingaku = jisshitsufutan.get第3段階_個室金額();
        source.koshitsuKijunCheck = jisshitsufutan.get基準額_個室チェック();
        source.koshitsuKijunKingaku = jisshitsufutan.get基準額_個室金額();
        source.junKoshitsu1Check = jisshitsufutan.get第1段階_準個室チェック();
        source.junKoshitsu1Kingaku = jisshitsufutan.get第1段階_準個室金額();
        source.junKoshitsu2_1Check = jisshitsufutan.get第2_1段階_準個室チェック();
        source.junKoshitsu2_1Kingaku = jisshitsufutan.get第2_1段階_準個室金額();
        source.junKoshitsu2_2Check = jisshitsufutan.get第2_2段階_準個室チェック();
        source.junKoshitsu2_2Kingaku = jisshitsufutan.get第2_2段階_準個室金額();
        source.junKoshitsu3Check = jisshitsufutan.get第3段階_準個室チェック();
        source.junKoshitsu3Kingaku = jisshitsufutan.get第3段階_準個室金額();
        source.junKoshitsuKijunCheck = jisshitsufutan.get基準額_準個室チェック();
        source.junKoshitsuKijunKingaku = jisshitsufutan.get基準額_準個室金額();
        source.tokuyo1Check = jisshitsufutan.get第1段階_従来型個室_特養チェック();
        source.tokuyo1Kingaku = jisshitsufutan.get第1段階_従来型個室_特養金額();
        source.tokuyo2_1Check = jisshitsufutan.get第2_1段階_従来型個室_特養チェック();
        source.tokuyo2_1Kingaku = jisshitsufutan.get第2_1段階_従来型個室_特養金額();
        source.tokuyo2_2Check = jisshitsufutan.get第2_2段階_従来型個室_特養チェック();
        source.tokuyo2_2Kingaku = jisshitsufutan.get第2_2段階_従来型個室_特養金額();
        source.tokuyo2_3Check = jisshitsufutan.get第2_3段階_従来型個室_特養チェック();
        source.tokuyo2_3Kingaku = jisshitsufutan.get第2_3段階_従来型個室_特養金額();
        source.tokuyo3Check = jisshitsufutan.get第3段階_従来型個室_特養チェック();
        source.tokuyo3Kingaku = jisshitsufutan.get第3段階_従来型個室_特養金額();
        source.tokuyoKijunCheck = jisshitsufutan.get基準額_従来型個室_特養チェック();
        source.tokuyoKijunKingaku = jisshitsufutan.get基準額_従来型個室_特養金額();
        source.tashoshitsu1Check = jisshitsufutan.get第1段階_多床室チェック();
        source.tashoshitsu1Kingaku = jisshitsufutan.get第1段階_多床室金額();
        source.tashoshitsu2_1Check = jisshitsufutan.get第2_1段階_多床室チェック();
        source.tashoshitsu2_1Kingaku = jisshitsufutan.get第2_1段階_多床室金額();
        source.tashoshitsu2_2Check = jisshitsufutan.get第2_2段階_多床室チェック();
        source.tashochitsu2_2Kingaku = jisshitsufutan.get第2_2段階_多床室金額();
        source.tashoshitsu3Check = jisshitsufutan.get第3段階_多床室チェック();
        source.tashoshitsu3Kingaku = jisshitsufutan.get第3段階_多床室金額();
        source.tashoshitsuKijunCheck = jisshitsufutan.get基準額_多床室チェック();
        source.tashoshitsuKijunKingaku = jisshitsufutan.get基準額_多床室金額();
        source.shokuhiCheck = jisshitsufutan.get食費負担限度額記載チェック();
        source.shokuhi1Check = jisshitsufutan.get食費チェック1();
        source.shokuhi1Kingaku = jisshitsufutan.get食費金額1();
        source.shokuhi2Check = jisshitsufutan.get食費チェック2();
        source.shokuhi2Kingaku = jisshitsufutan.get食費金額2();
        source.shokuhi3Check = jisshitsufutan.get食費チェック3();
        source.shokuhi3Kingaku = jisshitsufutan.get食費金額3();
        source.shokuhi4Check = jisshitsufutan.get食費チェック4();
        source.shokuhi4Kingaku = jisshitsufutan.get食費金額4();
        source.shokuhiOtherKingaku = jisshitsufutan.get食費金額その他();
        source.kogakuKaigoCheck = jisshitsufutan.get高額介護サービス費の支給による自己負担上限月額記載チェック();
        source.kogakuKaigo1Check = jisshitsufutan.get高額介護チェック1();
        source.kogakuKaigo1Kingaku = jisshitsufutan.get高額介護金額1();
        source.kogakuKaigo2Check = jisshitsufutan.get高額介護チェック2();
        source.kogakuKaigo2Kingaku = jisshitsufutan.get高額介護金額2();
        source.kogakuKaigo3Check = jisshitsufutan.get高額介護チェック3();
        source.kogakuKaigo3Kingaku = jisshitsufutan.get高額介護金額3();
        source.kogakuKaigo4Check = jisshitsufutan.get高額介護チェック4();
        source.kogakuKaigo4Kingaku = jisshitsufutan.get高額介護金額4();
        source.kogakuKaigoOtherKingaku = jisshitsufutan.get高額介護金額その他();
        source.kaigoHokenryoCheck = jisshitsufutan.get介護保険料記載チェック();
        source.kaigoHokenryo1Check = jisshitsufutan.get保険料チェック1();
        source.kaigoHokenryo1Kingaku = jisshitsufutan.get保険料金額1();
        source.kaigoHokenryo2Check = jisshitsufutan.get保険料チェック2();
        source.kaigoHokenryo2Kingaku = jisshitsufutan.get保険料金額2();
        source.kaigoHokenryo3Check = jisshitsufutan.get保険料チェック3();
        source.kaigoHokenryo3Kingaku = jisshitsufutan.get保険料金額3();
        source.kaigoHokenryo4Check = jisshitsufutan.get保険料チェック4();
        source.kaigoHokenryo4Kingaku = jisshitsufutan.get保険料金額4();
        source.kaigoHokenryo5Check = jisshitsufutan.get保険料チェック5();
        source.kaigoHokenryo5Kingaku = jisshitsufutan.get保険料金額5();
        source.kaigoHokenryo6Check = jisshitsufutan.get保険料チェック6();
        source.kaigoHokenryo6Kingaku = jisshitsufutan.get保険料金額6();
        source.kaigoHokenryo7Check = jisshitsufutan.get保険料チェック7();
        source.kaigoHokenryo7Kingaku = jisshitsufutan.get保険料金額7();
        source.kaigoHokenryo8Check = jisshitsufutan.get保険料チェック8();
        source.kaigoHokenryo8Kingaku = jisshitsufutan.get保険料金額8();
        source.kaigoHokenryo9Check = jisshitsufutan.get保険料チェック9();
        source.kaigoHokenryo9Kingaku = jisshitsufutan.get保険料金額9();
        source.kaigoHokenryo10Check = jisshitsufutan.get保険料チェック10();
        source.kaigoHokenryo10Kingaku = jisshitsufutan.get保険料金額10();
        source.kaigoHokenryo11Check = jisshitsufutan.get保険料チェック11();
        source.kaigoHokenryo11Kingaku = jisshitsufutan.get保険料金額11();
        source.kaigoHokenryoOtherCheck = jisshitsufutan.get保険料チェックその他();
        source.kaigoHokenryoOtherKingaku = jisshitsufutan.get保険料金額その他();
        source.hokenryoDankai1 = jisshitsufutan.get保険料段階1();
        source.hokenryoDankai2 = jisshitsufutan.get保険料段階2();
        source.hokenryoDankai3 = jisshitsufutan.get保険料段階3();
        source.hokenryoDankai4 = jisshitsufutan.get保険料段階4();
        source.hokenryoDankai5 = jisshitsufutan.get保険料段階5();
        source.hokenryoDankai6 = jisshitsufutan.get保険料段階6();
        source.hokenryoDankai7 = jisshitsufutan.get保険料段階7();
        source.hokenryoDankai8 = jisshitsufutan.get保険料段階8();
        source.hokenryoDankai9 = jisshitsufutan.get保険料段階9();
        source.hokenryoDankai10 = jisshitsufutan.get保険料段階10();
        source.hokenryoDankai11 = jisshitsufutan.get保険料段階11();
        source.hokenryoDankai12 = jisshitsufutan.get保険料段階12();
        source.biko = jisshitsufutan.get備考();
        source.hokenryoDankaiUp1 = jisshitsufutan.get保険料段階1_上段();
        source.hokenryoDankaiUp2 = jisshitsufutan.get保険料段階2_上段();
        source.hokenryoDankaiUp3 = jisshitsufutan.get保険料段階3_上段();
        source.hokenryoDankaiUp4 = jisshitsufutan.get保険料段階4_上段();
        source.hokenryoDankaiUp5 = jisshitsufutan.get保険料段階5_上段();
        source.hokenryoDankaiUp6 = jisshitsufutan.get保険料段階6_上段();
        source.hokenryoDankaiUp7 = jisshitsufutan.get保険料段階7_上段();
        source.hokenryoDankaiUp8 = jisshitsufutan.get保険料段階8_上段();
        source.hokenryoDankaiUp9 = jisshitsufutan.get保険料段階9_上段();
        source.hokenryoDankaiUp10 = jisshitsufutan.get保険料段階10_上段();
        source.hokenryoDankaiUp11 = jisshitsufutan.get保険料段階11_上段();
        source.hokenryoDankaiUp12 = jisshitsufutan.get保険料段階12_上段();
        source.hokenryoDankaiDown1 = jisshitsufutan.get保険料段階1_下段();
        source.hokenryoDankaiDown2 = jisshitsufutan.get保険料段階2_下段();
        source.hokenryoDankaiDown3 = jisshitsufutan.get保険料段階3_下段();
        source.hokenryoDankaiDown4 = jisshitsufutan.get保険料段階4_下段();
        source.hokenryoDankaiDown5 = jisshitsufutan.get保険料段階5_下段();
        source.hokenryoDankaiDown6 = jisshitsufutan.get保険料段階6_下段();
        source.hokenryoDankaiDown7 = jisshitsufutan.get保険料段階7_下段();
        source.hokenryoDankaiDown8 = jisshitsufutan.get保険料段階8_下段();
        source.hokenryoDankaiDown9 = jisshitsufutan.get保険料段階9_下段();
        source.hokenryoDankaiDown10 = jisshitsufutan.get保険料段階10_下段();
        source.hokenryoDankaiDown11 = jisshitsufutan.get保険料段階11_下段();
        source.hokenryoDankaiDown12 = jisshitsufutan.get保険料段階12_下段();
        return source;
    }

}
