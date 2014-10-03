/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.NichijoSeikatsuJiritsudoKumiawase;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiChukanHyokaKomokuTokuten;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiKijunTime;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChukanHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DentatsuNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiResultSofuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinchiNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShokujiKoiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TankiKiokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NichijoSeikatsuJiritsudoKumiawaseItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiKijunTimeItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

/**
 * 一次判定のテストで使用されるEntityを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiTestEntityCreator {

    private IchijiHanteiTestEntityCreator() {
    }

    /**
     * 一次判定結果Entityを生成して返します。
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity() {
        YokaigoNinteiKijunTime 要介護認定等基準時間 = create要介護認定等基準時間(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点 = create中間項目得点群(1, 2, 3, 4, 5, 6, 7);
        NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ = create日常生活自立度組み合わせ(21, 22, 23, 24, 25, 26, 27);

        return create一次判定結果Entity(new ShinseishoKanriNo(new RString("01")), KoroshoIFKubun.V02A, KariIchijiHanteiKubun.本判定,
                new FlexibleDate("20060401"), new Code("01"), new Code("12"), 要介護認定等基準時間, 中間評価項目得点,
                create警告配列コード文字列(new FlexibleDate("20060401")), new Code("3"), new Decimal(12.34), new Code("4"),
                new Code("5"), 日常生活自立度組み合わせ, new Code("6"), 48, IchijiHanteiResultSofuKubun.送付済み, new FlexibleDate("20061231"));
    }

    private static RString create警告配列コード文字列(FlexibleDate 判定年月日) {
        int 警告数 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日).get警告数();
        RStringBuilder builder = new RStringBuilder();
        for (int i = 0; i < 警告数; i++) {
            builder.append(new RString("0"));
        }
        return builder.toRString();
    }

    private static YokaigoNinteiKijunTime create要介護認定等基準時間(int 基準時間_合計, int 基準時間_食事,
            int 基準時間_排泄, int 基準時間_移動, int 基準時間_清潔保持, int 基準時間_間接ケア,
            int 基準時間_BPSD関連, int 基準時間_機能訓練, int 基準時間_医療関連, int 基準時間_認知症加算) {
        Map<YokaigoNinteiKijunTimeItem, Integer> 基準時間Map = new EnumMap<>(YokaigoNinteiKijunTimeItem.class);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.合計, 基準時間_合計);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.食事, 基準時間_食事);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.排泄, 基準時間_排泄);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.移動, 基準時間_移動);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.清潔保持, 基準時間_清潔保持);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.間接ケア, 基準時間_間接ケア);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.BPSD関連, 基準時間_BPSD関連);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.機能訓練, 基準時間_機能訓練);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.医療関連, 基準時間_医療関連);
        基準時間Map.put(YokaigoNinteiKijunTimeItem.認知症加算, 基準時間_認知症加算);
        return new YokaigoNinteiKijunTime(基準時間Map);
    }

    private static YokaigoNinteiChukanHyokaKomokuTokuten create中間項目得点群(int 第1群, int 第2群, int 第3群,
            int 第4群, int 第5群, int 第6群, int 第7群) {
        Map<ChukanHyokaKomoku, Integer> 得点群 = new EnumMap<>(ChukanHyokaKomoku.class);
        得点群.put(ChukanHyokaKomoku.第1群, 第1群);
        得点群.put(ChukanHyokaKomoku.第2群, 第2群);
        得点群.put(ChukanHyokaKomoku.第3群, 第3群);
        得点群.put(ChukanHyokaKomoku.第4群, 第4群);
        得点群.put(ChukanHyokaKomoku.第5群, 第5群);
        得点群.put(ChukanHyokaKomoku.第6群, 第6群);
        得点群.put(ChukanHyokaKomoku.第7群, 第7群);
        return new YokaigoNinteiChukanHyokaKomokuTokuten(得点群);
    }

    private static NichijoSeikatsuJiritsudoKumiawase create日常生活自立度組み合わせ(int 自立, int 要支援, int 要介護1,
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
     * 一次判定結果Entityを生成して返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param IF区分 IF区分
     * @param 仮判定区分 仮判定区分
     * @param 一次判定年月日 一次判定年月日
     * @param 一次判定結果コード 一次判定結果コード
     * @param 認知症加算一次判定結果コード 認知症加算一次判定結果コード
     * @param 要介護認定等基準時間 要介護認定等合計
     * @param 要介護認定中間評価項目得点 要介護認定中間評価項目得点
     * @param 警告配列コード 警告配列コード
     * @param 状態安定性コード 状態安定性コード
     * @param 認知症高齢者自立度2以上蓋然性 認知症高齢者自立度2以上蓋然性
     * @param 給付区分コード 給付区分コード
     * @param 運動能力未低下認知症高齢者の指標コード 運動能力未低下認知症高齢者の指標コード
     * @param 日常生活自立度組み合わせ 日常生活自立度組み合わせ
     * @param 蓋然性評価コード 蓋然性評価コード
     * @param 蓋然性評価率 蓋然性評価率
     * @param 結果送付区分 結果送付区分
     * @param 結果送付年月 結果送付年月
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(ShinseishoKanriNo 申請書管理番号, KoroshoIFKubun IF区分,
            KariIchijiHanteiKubun 仮判定区分, FlexibleDate 一次判定年月日, Code 一次判定結果コード, Code 認知症加算一次判定結果コード,
            YokaigoNinteiKijunTime 要介護認定等基準時間, YokaigoNinteiChukanHyokaKomokuTokuten 要介護認定中間評価項目得点,
            RString 警告配列コード, Code 状態安定性コード, Decimal 認知症高齢者自立度2以上蓋然性, Code 給付区分コード,
            Code 運動能力未低下認知症高齢者の指標コード, NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ, Code 蓋然性評価コード,
            int 蓋然性評価率, IchijiHanteiResultSofuKubun 結果送付区分, FlexibleDate 結果送付年月) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = new DbT5016IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setKoroshoIfShikibetsuCode(IF区分.getCode());
        entity.setKariIchijiHanteiKubun(仮判定区分.is仮判定());
        entity.setIchijiHanteiYMD(一次判定年月日);
        entity.setIchijiHanteiKekkaCode(一次判定結果コード);
        entity.setIchijiHanteiKekkaNinchishoKasanCode(認知症加算一次判定結果コード);
        entity.setKijunJikan(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.合計));
        entity.setKijunJikanShokuji(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.食事));
        entity.setKijunJikanHaisetsu(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.排泄));
        entity.setKijunJikanIdo(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.移動));
        entity.setKijunJikanSeiketsuHoji(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.清潔保持));
        entity.setKijunJikanKansetsuCare(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.間接ケア));
        entity.setKijunJikanBPSDKanren(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.BPSD関連));
        entity.setKijunJikanKinoKunren(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.機能訓練));
        entity.setKijunJikanIryoKanren(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.医療関連));
        entity.setKijunJikanNinchishoKasan(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItem.認知症加算));
        entity.setChukanHyokaKomoku1gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第1群));
        entity.setChukanHyokaKomoku2gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第2群));
        entity.setChukanHyokaKomoku3gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第3群));
        entity.setChukanHyokaKomoku4gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第4群));
        entity.setChukanHyokaKomoku5gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第5群));
        entity.setChukanHyokaKomoku6gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第6群));
        entity.setChukanHyokaKomoku7gun(要介護認定中間評価項目得点.get中間評価項目得点(ChukanHyokaKomoku.第7群));
        entity.setIchijiHanteiKeikokuCode(警告配列コード);
        entity.setJotaiAnteiseiCode(状態安定性コード);
        entity.setNinchishoJiritsudoIIijoNoGaizensei(認知症高齢者自立度2以上蓋然性);
        entity.setSuiteiKyufuKubunCode(給付区分コード);
        entity.setNinchishoKoreishaShihyoCode(運動能力未低下認知症高齢者の指標コード);
        entity.setJiritsudoKumiawase1(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.自立));
        entity.setJiritsudoKumiawase2(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.要支援));
        entity.setJiritsudoKumiawase3(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.要介護1));
        entity.setJiritsudoKumiawase4(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.要介護2));
        entity.setJiritsudoKumiawase5(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.要介護3));
        entity.setJiritsudoKumiawase6(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.要介護4));
        entity.setJiritsudoKumiawase7(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItem.要介護5));
        entity.setGaizenseiHyokaCode(蓋然性評価コード);
        entity.setGaizenseiHyokaPercent(蓋然性評価率);
        entity.setIchijiHanteiSofuKubun(結果送付区分.get送付区分コード());
        entity.setIchijiHanteiKekkaSofuYMD(結果送付年月);
        return entity;
    }

    /**
     * 一次判定結果Entityを生成して返します。(spy)
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy() {
        return set一次判定結果コードマスタ項目(create一次判定結果Entity());
    }

    /**
     * 一次判定結果Entityを生成して返します。（Spy）
     *
     * @param 申請書管理番号 申請書管理番号
     * @param IF区分 IF区分
     * @param 仮判定区分 仮判定区分
     * @param 一次判定年月日 一次判定年月日
     * @param 一次判定結果コード 一次判定結果コード
     * @param 認知症加算一次判定結果コード 認知症加算一次判定結果コード
     * @param 要介護認定等基準時間 要介護認定等合計
     * @param 要介護認定中間評価項目得点 要介護認定中間評価項目得点
     * @param 警告配列コード 警告配列コード
     * @param 状態安定性コード 状態安定性コード
     * @param 認知症高齢者自立度2以上蓋然性 認知症高齢者自立度2以上蓋然性
     * @param 給付区分コード 給付区分コード
     * @param 運動能力未低下認知症高齢者の指標コード 運動能力未低下認知症高齢者の指標コード
     * @param 日常生活自立度組み合わせ 日常生活自立度組み合わせ
     * @param 蓋然性評価コード 蓋然性評価コード
     * @param 蓋然性評価率 蓋然性評価率
     * @param 結果送付区分 結果送付区分
     * @param 結果送付年月 結果送付年月
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy(ShinseishoKanriNo 申請書管理番号, KoroshoIFKubun IF区分,
            KariIchijiHanteiKubun 仮判定区分, FlexibleDate 一次判定年月日, Code 一次判定結果コード, Code 認知症加算一次判定結果コード,
            YokaigoNinteiKijunTime 要介護認定等基準時間, YokaigoNinteiChukanHyokaKomokuTokuten 要介護認定中間評価項目得点,
            RString 警告配列コード, Code 状態安定性コード, Decimal 認知症高齢者自立度2以上蓋然性, Code 給付区分コード,
            Code 運動能力未低下認知症高齢者の指標コード, NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ, Code 蓋然性評価コード,
            int 蓋然性評価率, IchijiHanteiResultSofuKubun 結果送付区分, FlexibleDate 結果送付年月) {
        return set一次判定結果コードマスタ項目(create一次判定結果Entity(申請書管理番号, IF区分, 仮判定区分, 一次判定年月日, 一次判定結果コード,
                認知症加算一次判定結果コード, 要介護認定等基準時間, 要介護認定中間評価項目得点, 警告配列コード, 状態安定性コード,
                認知症高齢者自立度2以上蓋然性, 給付区分コード, 運動能力未低下認知症高齢者の指標コード, 日常生活自立度組み合わせ,
                蓋然性評価コード, 蓋然性評価率, 結果送付区分, 結果送付年月));
    }

    private static DbT5016IchijiHanteiKekkaJohoEntity set一次判定結果コードマスタ項目(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        entity = spy(entity);
        doReturn(new RString("meisho")).when(entity).getIchijiHanteiKekkaCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getIchijiHanteiKekkaNinchishoKasanCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getJotaiAnteiseiCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getSuiteiKyufuKubunCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getNinchishoKoreishaShihyoCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getGaizenseiHyokaCodeMeisho();
        doReturn(new RString("ryakusho")).when(entity).getIchijiHanteiKekkaCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getIchijiHanteiKekkaNinchishoKasanCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getJotaiAnteiseiCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getSuiteiKyufuKubunCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getNinchishoKoreishaShihyoCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getGaizenseiHyokaCodeRyakusho();
        return entity;
    }

    /**
     * 申請書管理番号を外部から指定して、一次判定結果Entityを生成して返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(String 申請書管理番号) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = create一次判定結果Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        return entity;
    }

    /**
     * 申請書管理番号を外部から指定して、一次判定結果Entityを生成して返します。(Spy)
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy(String 申請書管理番号) {
        return (set一次判定結果コードマスタ項目(create一次判定結果Entity(申請書管理番号)));
    }

    /**
     * 申請書管理番号と仮一次判定フラグを外部から指定して、一次判定結果Entityを生成して返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 仮一次判定フラグ 仮一次判定フラグ
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(String 申請書管理番号, boolean 仮一次判定フラグ) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = create一次判定結果Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setKariIchijiHanteiKubun(仮一次判定フラグ);
        return entity;
    }

    /**
     * 申請書管理番号と仮一次判定フラグを外部から指定して、一次判定結果Entityを生成して返します。(Spy)
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 仮一次判定フラグ 仮一次判定フラグ
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy(String 申請書管理番号, boolean 仮一次判定フラグ) {
        return set一次判定結果コードマスタ項目(create一次判定結果Entity(申請書管理番号, 仮一次判定フラグ));
    }

    /**
     * 主治医意見書詳細情報Entityの中で、一次判定処理に使用される主治医意見書5項目の要素を持ったEntityを返します。
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity() {
        return create主治医意見書5項目Entity(KoroshoIFKubun.V02A, new Code("9"), new Code("8"), TankiKiokuKomoku.問題あり,
                NinchiNoryokuKomoku.判断できない, DentatsuNoryokuKomoku.具体的要求に限られる,
                ShokujiKoiHyokaKomoku.自立ないし何とか自分で食べられる);
    }

    /**
     * 主治医意見書詳細情報Entityの中で、一次判定処理に使用される主治医意見書5項目の要素を持ったEntityを返します。
     *
     * @param 厚労省IF区分 厚労省IF区分
     * @param 障害高齢者生活自立度コード 障害高齢者生活自立度コード
     * @param 認知症高齢者生活自立度コード 認知症高齢者生活自立度コード
     * @param 短期記憶項目 短期記憶項目
     * @param 認知能力記憶 認知能力記憶
     * @param 伝達能力項目 伝達能力項目
     * @param 食事行為評価項目 食事行為評価項目
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity(KoroshoIFKubun 厚労省IF区分,
            Code 障害高齢者生活自立度コード, Code 認知症高齢者生活自立度コード, TankiKiokuKomoku 短期記憶項目, NinchiNoryokuKomoku 認知能力記憶,
            DentatsuNoryokuKomoku 伝達能力項目, ShokujiKoiHyokaKomoku 食事行為評価項目) {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setKoroshoIfShikibetsuCode(厚労省IF区分.getCode());
        entity.setIk_seikatsuJiritsudoShyogaiCode(障害高齢者生活自立度コード);
        entity.setIk_seikatsuJiritsudoNinchshoCode(認知症高齢者生活自立度コード);
        entity.setIk_chukakuShojoTankiKioku(短期記憶項目.get項目コード());
        entity.setIk_chukakuShojoNinchiNoryoku(認知能力記憶.get項目コード());
        entity.setIk_chukakuShojoDentatsuNoryoku(伝達能力項目.get項目コード());
        entity.setIk_shokuseikatsuShokujiKoi(食事行為評価項目.get項目コード());
        return entity;
    }

    /**
     * 主治医意見書詳細情報Entityの中で、一次判定処理に使用される主治医意見書5項目の要素を持ったEntityを返します。(Spy)
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目EntitySpy() {
        return set主治医意見書コードマスタ項目(create主治医意見書5項目Entity());
    }

    /**
     * 主治医意見書詳細情報Entityの中で、一次判定処理に使用される主治医意見書5項目の要素を持ったEntityを返します。(Spy)
     *
     * @param 厚労省IF区分 厚労省IF区分
     * @param 障害高齢者生活自立度コード 障害高齢者生活自立度コード
     * @param 認知症高齢者生活自立度コード 認知症高齢者生活自立度コード
     * @param 短期記憶項目 短期記憶項目
     * @param 認知能力記憶 認知能力記憶
     * @param 伝達能力項目 伝達能力項目
     * @param 食事行為評価項目 食事行為評価項目
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目EntitySpy(KoroshoIFKubun 厚労省IF区分,
            Code 障害高齢者生活自立度コード, Code 認知症高齢者生活自立度コード, TankiKiokuKomoku 短期記憶項目, NinchiNoryokuKomoku 認知能力記憶,
            DentatsuNoryokuKomoku 伝達能力項目, ShokujiKoiHyokaKomoku 食事行為評価項目) {
        return set主治医意見書コードマスタ項目(create主治医意見書5項目Entity(厚労省IF区分, 障害高齢者生活自立度コード, 認知症高齢者生活自立度コード,
                短期記憶項目, 認知能力記憶, 伝達能力項目, 食事行為評価項目));
    }

    private static DbT5013ShujiiIkenshoShosaiJohoEntity set主治医意見書コードマスタ項目(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        entity = spy(entity);
        doReturn(new RString("meisho")).when(entity).getIk_seikatsuJiritsudoShyogaiCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getIk_seikatsuJiritsudoNinchshoCodeMeisho();
        doReturn(new RString("ryakujo")).when(entity).getIk_seikatsuJiritsudoShyogaiCodeRyakusho();
        doReturn(new RString("ryakujo")).when(entity).getIk_seikatsuJiritsudoNinchshoCodeRyakusho();
        return entity;
    }

    /**
     * 申請書管理番号と履歴番号を指定し、一次判定で使用される主治医意見書詳細情報Entityを生成して返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 履歴番号 履歴番号
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity(String 申請書管理番号, int 履歴番号) {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = create主治医意見書5項目Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setIkenshoIraiRirekiNo(履歴番号);
        return entity;
    }

    /**
     * 主治医意見書5項目回答結果の数列を指定して、その情報を元に主治医意見書詳細情報Entityを生成します。
     *
     * @param 回答結果数列 回答結果数列
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity(String 回答結果数列) {
        RString 回答結果 = new RString(回答結果数列);
        回答結果 = 回答結果.padZeroToLeft(5);

        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setIk_seikatsuJiritsudoShyogaiCode(new Code("9"));
        entity.setIk_seikatsuJiritsudoNinchshoCode(new Code(回答結果.stringAt(0)));
        entity.setIk_chukakuShojoTankiKioku(TankiKiokuKomoku.toValue(回答結果.stringAt(1)).get項目コード());
        entity.setIk_chukakuShojoNinchiNoryoku(NinchiNoryokuKomoku.toValue(回答結果.stringAt(2)).get項目コード());
        entity.setIk_chukakuShojoDentatsuNoryoku(DentatsuNoryokuKomoku.toValue(回答結果.stringAt(3)).get項目コード());
        entity.setIk_shokuseikatsuShokujiKoi(ShokujiKoiHyokaKomoku.toValue(回答結果.stringAt(4)).get項目コード());

        return entity;
    }

    /**
     * 主治医意見書5項目回答結果の数列を指定して、その情報を元に主治医意見書詳細情報Entityを生成します。(Spy)
     *
     * @param 回答結果数列 回答結果数列
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目EntitySpy(String 回答結果数列) {
        return set主治医意見書コードマスタ項目(create主治医意見書5項目Entity(回答結果数列));
    }

    /**
     * 認定調査票Entityを生成して返します。
     *
     * @return 認定調査票Entity
     */
    public static DbT5009NinteichosahyoJohoEntity create認定調査票Entity() {
        return create認定調査票Entity(new ShinseishoKanriNo(new RString("01")),
                KoroshoIFKubun.V02A, new NinteichosaIraiRirekiNo(1),
                new RString("22222111112222211111222223333311111222223333344444111112222233333444445555511111222223333344444555556"));
    }

    /**
     * 認定調査票情報を生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param IF区分 IF区分
     * @param 依頼履歴番号 依頼履歴番号
     * @param 回答項目 回答項目
     * @return 認定調査票情報
     */
    public static DbT5009NinteichosahyoJohoEntity create認定調査票Entity(ShinseishoKanriNo 申請書管理番号, KoroshoIFKubun IF区分,
            NinteichosaIraiRirekiNo 依頼履歴番号, RString 回答項目) {
        if (回答項目.length() < 101) {
            回答項目.padRight("0", 101);
        }

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setKoroshoIfShikibetsuCode(IF区分.getCode());
        entity.setNinteichosaRirekiNo(依頼履歴番号.value());
        entity.setCk_mahiHidariJoshi(回答項目.stringAt(0));
        entity.setCk_mahiMigiJoshi(回答項目.stringAt(1));
        entity.setCk_mahiHidariKashi(回答項目.stringAt(2));
        entity.setCk_mahiMigiKashi(回答項目.stringAt(3));
        entity.setCk_mahiSonota(回答項目.stringAt(4));
        entity.setCk_koshukuKata(回答項目.stringAt(5));
        entity.setCk_koshukuHiji(回答項目.stringAt(6));
        entity.setCk_koshukuMata(回答項目.stringAt(7));
        entity.setCk_koshukuHiza(回答項目.stringAt(8));
        entity.setCk_koshukuAshi(回答項目.stringAt(9));
        entity.setCk_koshukuSonota(回答項目.stringAt(10));
        entity.setCk_negaeri(回答項目.stringAt(11));
        entity.setCk_okiagari(回答項目.stringAt(12));
        entity.setCk_zaihoji(回答項目.stringAt(13));
        entity.setCk_hisetchiZaihoji(回答項目.stringAt(14));
        entity.setCk_ryoashiRitsui(回答項目.stringAt(15));
        entity.setCk_hoko(回答項目.stringAt(16));
        entity.setCk_tachiagari(回答項目.stringAt(17));
        entity.setCk_kataashiRitsui(回答項目.stringAt(18));
        entity.setCk_yokusoDeiri(回答項目.stringAt(19));
        entity.setCk_senshin(回答項目.stringAt(20));
        entity.setCk_jokuso(回答項目.stringAt(21));
        entity.setCk_sonotaHihushikkan(回答項目.stringAt(22));
        entity.setCk_katateMunamotoage(回答項目.stringAt(23));
        entity.setCk_tumekiri(回答項目.stringAt(24));
        entity.setCk_shiryoku(回答項目.stringAt(25));
        entity.setCk_choryoku(回答項目.stringAt(26));
        entity.setCk_ijo(回答項目.stringAt(27));
        entity.setCk_ido(回答項目.stringAt(28));
        entity.setCk_enge(回答項目.stringAt(29));
        entity.setCk_shokujiSesshu(回答項目.stringAt(30));
        entity.setCk_insui(回答項目.stringAt(31));
        entity.setCk_hainyo(回答項目.stringAt(32));
        entity.setCk_haiben(回答項目.stringAt(33));
        entity.setCk_nyoi(回答項目.stringAt(34));
        entity.setCk_beni(回答項目.stringAt(35));
        entity.setCk_hainyogoShimatsu(回答項目.stringAt(36));
        entity.setCk_haibengoShimatsu(回答項目.stringAt(37));
        entity.setCk_kokoSeiketsu(回答項目.stringAt(38));
        entity.setCk_sengan(回答項目.stringAt(39));
        entity.setCk_seihatsu(回答項目.stringAt(40));
        entity.setCk_buttonKakehazushi(回答項目.stringAt(41));
        entity.setCk_joiChakudatsu(回答項目.stringAt(42));
        entity.setCk_zubonChakudatsu(回答項目.stringAt(43));
        entity.setCk_kutsushitaChakudatsu(回答項目.stringAt(44));
        entity.setCk_koshitsuSeiso(回答項目.stringAt(45));
        entity.setCk_gaishutsuHindo(回答項目.stringAt(46));
        entity.setCk_ishiDentatsu(回答項目.stringAt(47));
        entity.setCk_hanno(回答項目.stringAt(48));
        entity.setCk_nikka(回答項目.stringAt(49));
        entity.setCk_seinengappi(回答項目.stringAt(50));
        entity.setCk_tankiKioku(回答項目.stringAt(51));
        entity.setCk_namae(回答項目.stringAt(52));
        entity.setCk_kisetsu(回答項目.stringAt(53));
        entity.setCk_basho(回答項目.stringAt(54));
        entity.setCk_haikai(回答項目.stringAt(55));
        entity.setCk_gaishutsu(回答項目.stringAt(56));
        entity.setCk_higaiteki(回答項目.stringAt(57));
        entity.setCk_sakuwa(回答項目.stringAt(58));
        entity.setCk_genshiGencho(回答項目.stringAt(59));
        entity.setCk_kanjoHuantei(回答項目.stringAt(60));
        entity.setCk_chuyaGyakuten(回答項目.stringAt(61));
        entity.setCk_bogenBoko(回答項目.stringAt(62));
        entity.setCk_onajiHanashi(回答項目.stringAt(63));
        entity.setCk_ogoe(回答項目.stringAt(64));
        entity.setCk_kaigoNiTeiko(回答項目.stringAt(65));
        entity.setCk_ochitsuki(回答項目.stringAt(66));
        entity.setCk_hitoriDeDetagaru(回答項目.stringAt(67));
        entity.setCk_shushuheki(回答項目.stringAt(68));
        entity.setCk_hiNoHushimatsu(回答項目.stringAt(69));
        entity.setCk_monoYaIruiWoKowasu(回答項目.stringAt(70));
        entity.setCk_huketsuKoi(回答項目.stringAt(71));
        entity.setCk_ishokuKodo(回答項目.stringAt(72));
        entity.setCk_hidoiMonowasure(回答項目.stringAt(73));
        entity.setCk_seitekiMeiwakuKoi(回答項目.stringAt(74));
        entity.setCk_hitorigotoHitoriwarai(回答項目.stringAt(75));
        entity.setCk_jibunKatte(回答項目.stringAt(76));
        entity.setCk_hanashiGaMatomaranai(回答項目.stringAt(77));
        entity.setCk_kusuri(回答項目.stringAt(78));
        entity.setCk_kinsenKanri(回答項目.stringAt(79));
        entity.setCk_ishiKettei(回答項目.stringAt(80));
        entity.setCk_mukanshin(回答項目.stringAt(81));
        entity.setCk_shudanHutekio(回答項目.stringAt(82));
        entity.setCk_denwa(回答項目.stringAt(83));
        entity.setCk_kaimono(回答項目.stringAt(84));
        entity.setCk_chori(回答項目.stringAt(85));
        entity.setCk_tenteki(回答項目.stringAt(86));
        entity.setCk_chushinJomyakuEiyo(回答項目.stringAt(87));
        entity.setCk_toseki(回答項目.stringAt(88));
        entity.setCk_stomaShochi(回答項目.stringAt(89));
        entity.setCk_sansoRyoho(回答項目.stringAt(90));
        entity.setCk_respirator(回答項目.stringAt(91));
        entity.setCk_kikanSekkai(回答項目.stringAt(92));
        entity.setCk_totsuKango(回答項目.stringAt(93));
        entity.setCk_keikanEiyo(回答項目.stringAt(94));
        entity.setCk_monitorSokutei(回答項目.stringAt(95));
        entity.setCk_jokusoShochi(回答項目.stringAt(96));
        entity.setCk_catheter(回答項目.stringAt(97));
        entity.setCk_nitchuNoSeikatsuNiTsuite(回答項目.stringAt(98));
        entity.setCk_gaishutsuHindoNiTsuite(回答項目.stringAt(99));
        entity.setCk_jokyoHenka(回答項目.stringAt(100));
        return entity;
    }

    /**
     * 申請書管理番号と履歴番号を指定して、認定調査票Entityを生成して返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 履歴番号 履歴番号
     * @return 認定調査票Entity
     */
    public static DbT5009NinteichosahyoJohoEntity create認定調査票Entity(String 申請書管理番号, int 履歴番号) {
        DbT5009NinteichosahyoJohoEntity entity = create認定調査票Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setNinteichosaRirekiNo(履歴番号);
        return entity;
    }
}
