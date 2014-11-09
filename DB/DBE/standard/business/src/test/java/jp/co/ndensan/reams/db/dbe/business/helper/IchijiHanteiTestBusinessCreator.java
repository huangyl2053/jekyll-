/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuHairetsuCode;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultKomoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultSofu;
import jp.co.ndensan.reams.db.dbe.business.JotaiAnteiseiKubun;
import jp.co.ndensan.reams.db.dbe.business.NichijoSeikatsuJiritsudoKumiawase;
import jp.co.ndensan.reams.db.dbe.business.NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.business.NoryokuMiteikaNinchishoKoreishaShihyoKomoku;
import jp.co.ndensan.reams.db.dbe.business.SuiteiKyuhuKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiChukanHyokaKomokuTokuten;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiKijunTime;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChukanHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiResultSofuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NichijoSeikatsuJiritsudoKumiawaseItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiKijunTimeItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一次判定関連のテストで使用されるBusinessクラスのインスタンスを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiTestBusinessCreator {

    /**
     * 一次判定結果を生成します。
     *
     * @return 一次判定結果
     */
    public static IchijiHanteiResultDetail create一次判定結果() {

        return IchijiHanteiResultDetail.builder().set申請書管理番号(new ShinseishoKanriNo(new RString("01")))
                .set厚労省IF区分(KoroshoIFKubun.V02A)
                .set厚労省IF区分(KariIchijiHanteiKubun.本判定)
                .set一次判定年月日(new FlexibleDate("20060401"))
                .set一次判定結果(create一次判定結果項目())
                .set認知症加算一次判定結果(create認知症加算一次判定結果())
                .set要介護認定等基準時間(create要介護認定等基準時間(11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
                .set中間評価項目得点(create中間評価項目得点(1, 2, 3, 4, 5, 6, 7))
                .set一次判定警告List(create一次判定警告List(new FlexibleDate("20060401")))
                .set状態安定性(create介護認定状態安定性())
                .set認知症自立度2以上蓋然性(new Decimal(12.34))
                .set推定給付区分(create推定給付区分())
                .set運動能力未低下認知症高齢者指標(create能力未低下認知症高齢者指標())
                .set日常生活自立度組み合わせ(create日常生活自立度組み合わせ(21, 22, 23, 24, 25, 26, 27))
                .set認知症高齢者日常生活自立度蓋然性評価(create認知症高齢者自立度蓋然性評価())
                .set認知症高齢者日常生活自立度蓋然性評価率(48)
                .set一次判定結果送付状況(new IchijiHanteiResultSofu(IchijiHanteiResultSofuKubun.toValue(new RString("1")),
                                new FlexibleDate("20061231"))).build();
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

    /**
     * 年月日を受け取り、一次判定警告Listを返します。
     *
     * @param 判定年月日 判定年月日
     * @return 一次判定警告List
     */
    public static IchijiHanteiKeikokuList create一次判定警告List(FlexibleDate 判定年月日) {
        IchijiHanteiKeikokuHairetsuCode 警告配列コード
                = new IchijiHanteiKeikokuHairetsuCode(create警告配列コード文字列(判定年月日), new FlexibleDate("20060401"));
        return new IchijiHanteiKeikokuList(警告配列コード, Collections.EMPTY_LIST);
    }

    private static RString create警告配列コード文字列(FlexibleDate 判定年月日) {
        int 警告数 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日).get警告数();
        RStringBuilder builder = new RStringBuilder();
        for (int i = 0; i < 警告数; i++) {
            builder.append(new RString("0"));
        }
        return builder.toRString();
    }

    /**
     * 日常生活自立度組み合わせを生成します。
     *
     * @param 自立 自立
     * @param 要支援 要支援
     * @param 要介護1 要介護1
     * @param 要介護2 要介護2
     * @param 要介護3 要介護3
     * @param 要介護4 要介護4
     * @param 要介護5 要介護5
     * @return 日常生活自立度組み合わせ
     */
    public static NichijoSeikatsuJiritsudoKumiawase create日常生活自立度組み合わせ(int 自立, int 要支援, int 要介護1,
            int 要介護2, int 要介護3, int 要介護4, int 要介護5) {
        Map<NichijoSeikatsuJiritsudoKumiawaseItem, Integer> 日常生活自立度組み合わせ
                = new EnumMap<>(NichijoSeikatsuJiritsudoKumiawaseItem.class);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.自立, 自立);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.要支援, 要支援);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.要介護1, 要介護1);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.要介護2, 要介護2);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.要介護3, 要介護3);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.要介護4, 要介護4);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItem.要介護5, 要介護5);
        return new NichijoSeikatsuJiritsudoKumiawase(日常生活自立度組み合わせ);
    }

    /**
     * 要介護認定等合計を生成します。
     *
     * @param 基準時間_合計 基準時間_合計
     * @param 食事基準時間 食事合計
     * @param 排泄基準時間 排泄合計
     * @param 移動基準時間 移動合計
     * @param 清潔保持基準時間 清潔保持合計
     * @param 間接ケア基準時間 間接ケア合計
     * @param BPSD関連基準時間 BPSD関連合計
     * @param 機能訓練基準時間 機能訓練合計
     * @param 医療関連基準時間 医療関連合計
     * @param 認知症加算基準時間 認知症加算合計
     * @return 要介護認定等合計
     */
    public static YokaigoNinteiKijunTime create要介護認定等基準時間(int 基準時間_合計, int 食事基準時間, int 排泄基準時間,
            int 移動基準時間, int 清潔保持基準時間, int 間接ケア基準時間, int BPSD関連基準時間, int 機能訓練基準時間,
            int 医療関連基準時間, int 認知症加算基準時間) {
        Map<YokaigoNinteiKijunTimeItem, Integer> 要介護認定等基準時間 = new EnumMap<>(YokaigoNinteiKijunTimeItem.class);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.合計, 基準時間_合計);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.食事, 食事基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.排泄, 排泄基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.移動, 移動基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.清潔保持, 清潔保持基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.間接ケア, 間接ケア基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.BPSD関連, BPSD関連基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.機能訓練, 機能訓練基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.医療関連, 医療関連基準時間);
        要介護認定等基準時間.put(YokaigoNinteiKijunTimeItem.認知症加算, 認知症加算基準時間);
        return new YokaigoNinteiKijunTime(要介護認定等基準時間);
    }

    /**
     * 中間評価項目得点を生成します。
     *
     * @param 第1群 第1群
     * @param 第2群 第2群
     * @param 第3群 第3群
     * @param 第4群 第4群
     * @param 第5群 第5群
     * @param 第6群 第6群
     * @param 第7群 第7群
     * @return 中間評価項目得点
     */
    public static YokaigoNinteiChukanHyokaKomokuTokuten create中間評価項目得点(int 第1群, int 第2群, int 第3群, int 第4群,
            int 第5群, int 第6群, int 第7群) {
        Map<ChukanHyokaKomoku, Integer> 中間評価項目得点群 = new EnumMap<>(ChukanHyokaKomoku.class);
        中間評価項目得点群.put(ChukanHyokaKomoku.第1群, 第1群);
        中間評価項目得点群.put(ChukanHyokaKomoku.第2群, 第2群);
        中間評価項目得点群.put(ChukanHyokaKomoku.第3群, 第3群);
        中間評価項目得点群.put(ChukanHyokaKomoku.第4群, 第4群);
        中間評価項目得点群.put(ChukanHyokaKomoku.第5群, 第5群);
        中間評価項目得点群.put(ChukanHyokaKomoku.第6群, 第6群);
        中間評価項目得点群.put(ChukanHyokaKomoku.第7群, 第7群);
        return new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
    }
}
