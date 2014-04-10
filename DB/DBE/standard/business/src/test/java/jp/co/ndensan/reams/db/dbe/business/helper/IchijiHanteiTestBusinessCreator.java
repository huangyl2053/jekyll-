/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuHairetsuCode;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultKomoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.JotaiAnteiseiKubun;
import jp.co.ndensan.reams.db.dbe.business.NichijoSeikatsuJiritsudoKumiawase;
import jp.co.ndensan.reams.db.dbe.business.NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.business.NoryokuMiteikaNinchishoKoreishaShihyoKomoku;
import jp.co.ndensan.reams.db.dbe.business.SuiteiKyuhuKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiChukanHyokaKomokuTokuten;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiKijunTime;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiSohuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一次判定関連のテストで使用されるBusinessクラスのインスタンスを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiTestBusinessCreator {

    public static IchijiHanteiResultDetail create一次判定結果() {
        return new IchijiHanteiResultDetail(new ShinseishoKanriNo(new RString("01")),
                KoroshoIFKubun.V02A,
                KariIchijiHanteiKubun.本判定,
                new FlexibleDate("20060101"),
                create一次判定結果項目(),
                create認知症加算一次判定結果(),
                new YokaigoNinteiKijunTime(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
                new YokaigoNinteiChukanHyokaKomokuTokuten(1, 2, 3, 4, 5, 6, 7),
                create一次判定警告List("000111000111000111"),
                create介護認定状態安定性(),
                new Decimal(12.34),
                create推定給付区分(),
                create能力未低下認知症高齢者指標(),
                new NichijoSeikatsuJiritsudoKumiawase(21, 22, 23, 24, 25, 26, 27),
                create認知症高齢者自立度蓋然性評価(),
                48,
                IchijiHanteiSohuKubun.toValue(new RString("1")),
                new FlexibleDate("20061231"));
    }

    private static IchijiHanteiResultKomoku create一次判定結果項目() {
        return new IchijiHanteiResultKomoku(new Code("1"),
                new RString("一次判定結果"), new RString("一次判定結果略称"));
    }

    private static IchijiHanteiResultKomoku create認知症加算一次判定結果() {
        return new IchijiHanteiResultKomoku(new Code("2"),
                new RString("認知症加算一次判定結果"), new RString("認知症加算一次判定結果略称"));
    }

    private static JotaiAnteiseiKubun create介護認定状態安定性() {
        return new JotaiAnteiseiKubun(new Code("3"),
                new RString("介護認定状態安定性"), new RString("介護認定状態安定性略称"));
    }

    private static SuiteiKyuhuKubun create推定給付区分() {
        return new SuiteiKyuhuKubun(new Code("4"),
                new RString("推定給付区分"), new RString("推定給付区分略称"));
    }

    private static NoryokuMiteikaNinchishoKoreishaShihyoKomoku create能力未低下認知症高齢者指標() {
        return new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(new Code("5"),
                new RString("能力未低下認知症高齢者指標"), new RString("能力未低下認知症高齢者指標略称"));
    }

    private static NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku create認知症高齢者自立度蓋然性評価() {
        return new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(new Code("6"),
                new RString("認知症高齢者自立度蓋然性評価"), new RString("認知症高齢者自立度蓋然性評価略称"));
    }

    /**
     * 警告配列コードを表す文字列を受け取り、一次判定警告Listを返します。
     *
     * @param 警告配列コード文字列 警告配列コード文字列
     * @return 一次判定警告List
     */
    public static IchijiHanteiKeikokuList create一次判定警告List(String 警告配列コード文字列) {
        IchijiHanteiKeikokuHairetsuCode 警告配列コード = new IchijiHanteiKeikokuHairetsuCode(new RString(警告配列コード文字列),
                new FlexibleDate("20060401"));
        return new IchijiHanteiKeikokuList(警告配列コード, Collections.EMPTY_LIST);
    }
}
