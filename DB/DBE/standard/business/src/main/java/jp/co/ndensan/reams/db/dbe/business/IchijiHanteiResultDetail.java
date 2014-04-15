/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NichijoSeikatsuJiritsudoKumiawaseItemGroup;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定結果の、詳細な情報を表すクラスです。<br/>
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiResultDetail {

    private final ShinseishoKanriNo 申請書管理番号;
    private final KoroshoIFKubun 厚労省IF区分;
    private final KariIchijiHanteiKubun 仮一次判定区分;
    private final FlexibleDate 一次判定年月日;
    private final IchijiHanteiResultKomoku 一次判定結果;
    private final IchijiHanteiResultKomoku 認知症加算一次判定結果;
    private final YokaigoNinteiKijunTime 要介護認定等基準時間;
    private final YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点;
    private final IchijiHanteiKeikokuList 一次判定警告List;
    private final JotaiAnteiseiKubun 認定状態安定性;
    private final Decimal 認知症自立度2以上蓋然性;
    private final SuiteiKyuhuKubun 推定給付区分;
    private final NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標;
    private final NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ;
    private final NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価;
    private final int 認知症高齢者日常生活自立度蓋然性評価率;
    private final IchijiHanteiResultSofu 一次判定結果送付状況;

    /**
     * Builderから一次判定結果の詳細な情報を受け取り、インスタンスを生成します。
     *
     * @param builder 一次判定結果詳細Builder
     */
    private IchijiHanteiResultDetail(Builder builder) throws NullPointerException {
        this.申請書管理番号 = builder.申請書管理番号;
        this.厚労省IF区分 = builder.厚労省IF区分;
        this.仮一次判定区分 = builder.仮一次判定区分;
        this.一次判定年月日 = builder.一次判定年月日;
        this.一次判定結果 = builder.一次判定結果;
        this.認知症加算一次判定結果 = builder.認知症加算一次判定結果;
        this.要介護認定等基準時間 = builder.要介護認定等基準時間;
        this.中間評価項目得点 = builder.中間評価項目得点;
        this.一次判定警告List = builder.一次判定警告List;
        this.認定状態安定性 = builder.認定状態安定性;
        this.認知症自立度2以上蓋然性 = builder.認知症自立度2以上蓋然性;
        this.推定給付区分 = builder.推定給付区分;
        this.運動能力未低下認知症高齢者指標 = builder.運動能力未低下認知症高齢者指標;
        this.日常生活自立度組み合わせ = builder.日常生活自立度組み合わせ;
        this.認知症高齢者日常生活自立度蓋然性評価 = builder.認知症高齢者日常生活自立度蓋然性評価;
        this.認知症高齢者日常生活自立度蓋然性評価率 = builder.認知症高齢者日常生活自立度蓋然性評価率;
        this.一次判定結果送付状況 = builder.一次判定結果送付状況;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 厚労省IF区分を返します。
     *
     * @return 厚労省IF区分
     */
    public KoroshoIFKubun get厚労省IF区分() {
        return 厚労省IF区分;
    }

    /**
     * 仮一次判定区分を返します
     *
     * @return 仮一次判定区分
     */
    public KariIchijiHanteiKubun get仮一次判定区分() {
        return 仮一次判定区分;
    }

    /**
     * 一次判定年月日を返します。
     *
     * @return 一次判定年月日
     */
    public FlexibleDate get一次判定年月日() {
        return 一次判定年月日;
    }

    /**
     * 一次判定結果を返します。
     *
     * @return 一次判定結果
     */
    public IchijiHanteiResultKomoku get一次判定結果() {
        return 一次判定結果;
    }

    /**
     * 認知症加算一次判定結果を返します。
     *
     * @return 認知症加算一次判定結果
     */
    public IchijiHanteiResultKomoku get認知症加算一次判定結果() {
        return 認知症加算一次判定結果;
    }

    /**
     * 要介護認定等基準時間を返します。
     *
     * @return 要介護認定等基準時間
     */
    public YokaigoNinteiKijunTime get要介護認定等基準時間() {
        return 要介護認定等基準時間;
    }

    /**
     * 中間評価項目得点を返します。
     *
     * @return 中間評価項目得点
     */
    public YokaigoNinteiChukanHyokaKomokuTokuten get中間評価項目得点() {
        return 中間評価項目得点;
    }

    /**
     * 一次判定警告リストを返します。
     *
     * @return 一次判定警告リスト
     */
    public IchijiHanteiKeikokuList get一次判定警告List() {
        return 一次判定警告List;
    }

    /**
     * 認定状態安定性を返します。
     *
     * @return 認定状態安定性
     */
    public JotaiAnteiseiKubun get認定状態安定性() {
        return 認定状態安定性;
    }

    /**
     * 認知症自立度2以上蓋然性を返します。
     *
     * @return 認知症自立度2以上蓋然性
     */
    public Decimal get認知症自立度2以上蓋然性() {
        return 認知症自立度2以上蓋然性;
    }

    /**
     * 推定給付区分を返します。
     *
     * @return 推定給付区分
     */
    public SuiteiKyuhuKubun get推定給付区分() {
        return 推定給付区分;
    }

    /**
     * 運動能力未低下認知症高齢者指標を返します。
     *
     * @return 運動能力未低下認知症高齢者指標
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoKomoku get運動能力未低下認知症高齢者指標() {
        return 運動能力未低下認知症高齢者指標;
    }

    /**
     * 日常生活自立度組み合わせを返します。
     *
     * @return 日常生活自立度組み合わせ
     */
    public NichijoSeikatsuJiritsudoKumiawase get日常生活自立度組み合わせ() {
        return 日常生活自立度組み合わせ;
    }

    /**
     * 認知症高齢者日常生活自立度蓋然性評価を返します。
     *
     * @return 認知症高齢者日常生活自立度蓋然性評価
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku get認知症高齢者日常生活自立度蓋然性評価() {
        return 認知症高齢者日常生活自立度蓋然性評価;
    }

    /**
     * 認知症高齢者日常生活自立度蓋然性評価率を返します。
     *
     * @return 認知症高齢者日常生活自立度蓋然性評価率
     */
    public int get認知症高齢者日常生活自立度蓋然性評価率() {
        return 認知症高齢者日常生活自立度蓋然性評価率;
    }

    /**
     * 一次判定結果送付状況についての情報を返します。
     *
     * @return 一次判定結果送付状況
     */
    public IchijiHanteiResultSofu get一次判定結果送付状況() {
        return 一次判定結果送付状況;
    }

    /**
     * 一次判定結果詳細を生成するBuilderを生成して返します。
     *
     * @return 一次判定結果詳細Builder
     */
    public static ShinseishoKanriNoSetter builder() {
        return new Builder();
    }

    /**
     * 一次判定結果詳細のBuilderです。
     */
    public static final class Builder implements ShinseishoKanriNoSetter, KoroshoIFKubunSetter, KariIchijiHanteiKubunSetter, IchijiHanteiDateSetter,
            IchijiHanteiResultSetter, NinchishoKasanIchijiHanteiResultSetter, YokaigoNinteiKijunTimeSetter, ChukanHyokaKomokuTokutenSetter,
            IchijiHanteiKeikokuListSetter, JotaiAnteiseiSetter, GaizenseiSetter, SuiteiKyuhuKubunSetter, OthersSetter {

        private ShinseishoKanriNo 申請書管理番号;
        private KoroshoIFKubun 厚労省IF区分;
        private KariIchijiHanteiKubun 仮一次判定区分;
        private FlexibleDate 一次判定年月日;
        private IchijiHanteiResultKomoku 一次判定結果;
        private IchijiHanteiResultKomoku 認知症加算一次判定結果;
        private YokaigoNinteiKijunTime 要介護認定等基準時間;
        private YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点;
        private IchijiHanteiKeikokuList 一次判定警告List;
        private JotaiAnteiseiKubun 認定状態安定性;
        private Decimal 認知症自立度2以上蓋然性;
        private SuiteiKyuhuKubun 推定給付区分;
        private NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標;
        private NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ;
        private NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価;
        private int 認知症高齢者日常生活自立度蓋然性評価率;
        private IchijiHanteiResultSofu 一次判定結果送付状況;

        /**
         * 一次判定結果詳細のBuilderインスタンスを生成します。
         * 認定ソフト2006年度版のときに使用されていた指標や送付区分などについては、ここで初期値を設定します。
         */
        private Builder() {
            this.運動能力未低下認知症高齢者指標
                    = new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(new Code("1"), RString.EMPTY, RString.EMPTY);
            this.日常生活自立度組み合わせ = create日常生活自立度組み合わせ初期値();
            this.認知症高齢者日常生活自立度蓋然性評価
                    = new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(new Code("0"), RString.EMPTY, RString.EMPTY);
            this.認知症高齢者日常生活自立度蓋然性評価率 = 0;
            this.一次判定結果送付状況 = IchijiHanteiResultSofu.MI_SOFU;
        }

        private NichijoSeikatsuJiritsudoKumiawase create日常生活自立度組み合わせ初期値() {
            Map<NichijoSeikatsuJiritsudoKumiawaseItemGroup, Integer> 日常生活自立度組み合わせMap
                    = new EnumMap<>(NichijoSeikatsuJiritsudoKumiawaseItemGroup.class);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.自立, 0);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要支援, 0);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護1, 0);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護2, 0);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護3, 0);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護4, 0);
            日常生活自立度組み合わせMap.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護5, 0);
            return new NichijoSeikatsuJiritsudoKumiawase(日常生活自立度組み合わせMap);
        }

        @Override
        public IchijiHanteiResultDetail build() {
            return new IchijiHanteiResultDetail(this);
        }

        @Override
        public KoroshoIFKubunSetter set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
            requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
            this.申請書管理番号 = 申請書管理番号;
            return this;
        }

        @Override
        public KariIchijiHanteiKubunSetter set厚労省IF区分(KoroshoIFKubun 厚労省IF区分) {
            requireNonNull(厚労省IF区分, Messages.E00001.replace("厚労省IF区分").getMessage());
            this.厚労省IF区分 = 厚労省IF区分;
            return this;
        }

        @Override
        public IchijiHanteiDateSetter set厚労省IF区分(KariIchijiHanteiKubun 仮一次判定区分) {
            requireNonNull(仮一次判定区分, Messages.E00001.replace("仮一次判定区分").getMessage());
            this.仮一次判定区分 = 仮一次判定区分;
            return this;
        }

        @Override
        public IchijiHanteiResultSetter set一次判定年月日(FlexibleDate 一次判定年月日) {
            requireNonNull(一次判定年月日, Messages.E00001.replace("一次判定年月日").getMessage());
            this.一次判定年月日 = 一次判定年月日;
            return this;
        }

        @Override
        public NinchishoKasanIchijiHanteiResultSetter set一次判定結果(IchijiHanteiResultKomoku 一次判定結果) {
            requireNonNull(一次判定結果, Messages.E00001.replace("一次判定結果").getMessage());
            this.一次判定結果 = 一次判定結果;
            return this;
        }

        @Override
        public YokaigoNinteiKijunTimeSetter set認知症加算一次判定結果(IchijiHanteiResultKomoku 認知症加算一次判定結果) {
            requireNonNull(認知症加算一次判定結果, Messages.E00001.replace("認知症加算一次判定結果").getMessage());
            this.認知症加算一次判定結果 = 認知症加算一次判定結果;
            return this;
        }

        @Override
        public ChukanHyokaKomokuTokutenSetter set要介護認定等基準時間(YokaigoNinteiKijunTime 要介護認定等基準時間) {
            requireNonNull(要介護認定等基準時間, Messages.E00001.replace("要介護認定等基準時間").getMessage());
            this.要介護認定等基準時間 = 要介護認定等基準時間;
            return this;
        }

        @Override
        public IchijiHanteiKeikokuListSetter set中間評価項目得点(YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点) {
            requireNonNull(中間評価項目得点, Messages.E00001.replace("中間評価項目得点").getMessage());
            this.中間評価項目得点 = 中間評価項目得点;
            return this;
        }

        @Override
        public JotaiAnteiseiSetter set一次判定警告List(IchijiHanteiKeikokuList 一次判定警告List) {
            requireNonNull(一次判定警告List, Messages.E00001.replace("一次判定警告List").getMessage());
            this.一次判定警告List = 一次判定警告List;
            return this;
        }

        @Override
        public GaizenseiSetter set状態安定性(JotaiAnteiseiKubun 認定状態安定性) {
            requireNonNull(認定状態安定性, Messages.E00001.replace("認定状態安定性").getMessage());
            this.認定状態安定性 = 認定状態安定性;
            return this;
        }

        @Override
        public SuiteiKyuhuKubunSetter set認知症自立度2以上蓋然性(Decimal 認知症自立度2以上蓋然性) {
            requireNonNull(認知症自立度2以上蓋然性, Messages.E00001.replace("認知症自立度2以上蓋然性").getMessage());
            this.認知症自立度2以上蓋然性 = 認知症自立度2以上蓋然性;
            return this;
        }

        @Override
        public OthersSetter set推定給付区分(SuiteiKyuhuKubun 推定給付区分) {
            requireNonNull(推定給付区分, Messages.E00001.replace("推定給付区分").getMessage());
            this.推定給付区分 = 推定給付区分;
            return this;
        }

        @Override
        public OthersSetter set運動能力未低下認知症高齢者指標(NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標) {
            this.運動能力未低下認知症高齢者指標 = 運動能力未低下認知症高齢者指標;
            return this;
        }

        @Override
        public OthersSetter set日常生活自立度組み合わせ(NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ) {
            this.日常生活自立度組み合わせ = 日常生活自立度組み合わせ;
            return this;
        }

        @Override
        public OthersSetter set認知症高齢者日常生活自立度蓋然性評価(NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価) {
            this.認知症高齢者日常生活自立度蓋然性評価 = 認知症高齢者日常生活自立度蓋然性評価;
            return this;
        }

        @Override
        public OthersSetter set認知症高齢者日常生活自立度蓋然性評価率(int 認知症高齢者日常生活自立度蓋然性評価率) {
            this.認知症高齢者日常生活自立度蓋然性評価率 = 認知症高齢者日常生活自立度蓋然性評価率;
            return this;
        }

        @Override
        public OthersSetter set一次判定結果送付状況(IchijiHanteiResultSofu 一次判定結果送付状況) {
            this.一次判定結果送付状況 = 一次判定結果送付状況;
            return this;
        }
    }

    /**
     * 申請書管理番号を設定するためのSetterインターフェースです。
     */
    public interface ShinseishoKanriNoSetter {

        /**
         * 申請書管理番号を引数から設定します。
         *
         * @param 申請書管理番号 申請書管理番号
         * @return KoroshoIFKubunSetter
         */
        KoroshoIFKubunSetter set申請書管理番号(ShinseishoKanriNo 申請書管理番号);
    }

    /**
     * 厚労省IF区分を設定するためのSetterインターフェースです。
     */
    public interface KoroshoIFKubunSetter {

        /**
         * 厚労省IF区分を引数から設定します。
         *
         * @param 厚労省IF区分 厚労省IF区分
         * @return KariIchijiHanteiKubunSetter
         */
        KariIchijiHanteiKubunSetter set厚労省IF区分(KoroshoIFKubun 厚労省IF区分);
    }

    /**
     * 仮一次判定区分を設定するためのSetterインターフェースです。
     */
    public interface KariIchijiHanteiKubunSetter {

        /**
         * 仮一次判定区分を引数から設定します。
         *
         * @param 仮一次判定区分 仮一次判定区分
         * @return IchijiHanteiDateSetter
         */
        IchijiHanteiDateSetter set厚労省IF区分(KariIchijiHanteiKubun 仮一次判定区分);
    }

    /**
     * 一次判定年月日を設定するためのSetterインターフェースです。
     */
    public interface IchijiHanteiDateSetter {

        /**
         * 一次判定年月日を引数から設定します。
         *
         * @param 一次判定年月日 一次判定年月日
         * @return IchijiHanteiResultSetter
         */
        IchijiHanteiResultSetter set一次判定年月日(FlexibleDate 一次判定年月日);
    }

    /**
     * 一次判定結果を設定するためのSetterインターフェースです。
     */
    public interface IchijiHanteiResultSetter {

        /**
         * 一次判定結果を引数から設定します。
         *
         * @param 一次判定結果 一次判定結果
         * @return NinchishoKasanIchijiHanteiResultSetter
         */
        NinchishoKasanIchijiHanteiResultSetter set一次判定結果(IchijiHanteiResultKomoku 一次判定結果);
    }

    /**
     * 認知症加算一次判定結果を設定するためのSetterインターフェースです。
     */
    public interface NinchishoKasanIchijiHanteiResultSetter {

        /**
         * 認知症加算一次判定結果を引数から設定します。
         *
         * @param 認知症加算一次判定結果 認知症加算一次判定結果
         * @return YokaigoNinteiKijunTimeSetter
         */
        YokaigoNinteiKijunTimeSetter set認知症加算一次判定結果(IchijiHanteiResultKomoku 認知症加算一次判定結果);
    }

    /**
     * 要介護認定等基準時間を設定するためのSetterインターフェースです。
     */
    public interface YokaigoNinteiKijunTimeSetter {

        /**
         * 要介護認定等基準時間を引数から設定します。
         *
         * @param 要介護認定等基準時間 要介護認定等基準時間
         * @return ChukanHyokaKomokuTokutenSetter
         */
        ChukanHyokaKomokuTokutenSetter set要介護認定等基準時間(YokaigoNinteiKijunTime 要介護認定等基準時間);
    }

    /**
     * 中間評価項目得点群を設定するためのSetterインターフェースです。
     */
    public interface ChukanHyokaKomokuTokutenSetter {

        /**
         * 中間評価項目得点を引数から設定します。
         *
         * @param 中間評価項目得点 中間評価項目得点
         * @return IchijiHanteiKeikokuListSetter
         */
        IchijiHanteiKeikokuListSetter set中間評価項目得点(YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点);
    }

    /**
     * 一次判定警告Listを設定するためのSetterインターフェースです。
     */
    public interface IchijiHanteiKeikokuListSetter {

        /**
         * 一次判定警告Listを引数から設定します。
         *
         * @param 一次判定警告List 一次判定警告List
         * @return JotaiAnteiseiSetter
         */
        JotaiAnteiseiSetter set一次判定警告List(IchijiHanteiKeikokuList 一次判定警告List);
    }

    /**
     * 状態安定性を設定するためのSetterインターフェースです。
     */
    public interface JotaiAnteiseiSetter {

        /**
         * 状態安定性を引数から設定します。
         *
         * @param 状態安定性 状態安定性
         * @return GaizenseiSetter
         */
        GaizenseiSetter set状態安定性(JotaiAnteiseiKubun 状態安定性);
    }

    /**
     * 認知症自立度が2以上であることの蓋然性を設定するためのSetterインターフェースです。
     */
    public interface GaizenseiSetter {

        /**
         * 認知症自立度2以上蓋然性を引数から設定します。
         *
         * @param 認知症自立度2以上蓋然性 認知症自立度2以上蓋然性
         * @return SuiteiKyuhuKubunSetter
         */
        SuiteiKyuhuKubunSetter set認知症自立度2以上蓋然性(Decimal 認知症自立度2以上蓋然性);
    }

    /**
     * 推定給付区分を設定するためのSetterインターフェースです。
     */
    public interface SuiteiKyuhuKubunSetter {

        /**
         * 推定給付区分を引数から設定します。
         *
         * @param 推定給付区分 推定給付区分
         * @return OthersSetter
         */
        OthersSetter set推定給付区分(SuiteiKyuhuKubun 推定給付区分);
    }

    /**
     * 必須項目以外の項目について設定するためのインターフェースです。
     */
    public interface OthersSetter {

        /**
         * 運動能力が低下していない認知症高齢者の指標を、引数から設定します。
         *
         * @param 運動能力未低下認知症高齢者指標 運動能力が低下していない認知症高齢者の指標
         * @return OthersSetter
         */
        OthersSetter set運動能力未低下認知症高齢者指標(NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標);

        /**
         * 日常生活自立度組み合わせを、引数から設定します。
         *
         * @param 日常生活自立度組み合わせ 日常生活自立度組み合わせ
         * @return OthersSetter
         */
        OthersSetter set日常生活自立度組み合わせ(NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ);

        /**
         * 認知症高齢者日常生活自立度についての蓋然性評価を、引数から設定します。
         *
         * @param 認知症高齢者日常生活自立度蓋然性評価 認知症高齢者日常生活自立度についての蓋然性評価
         * @return OthersSetter
         */
        OthersSetter set認知症高齢者日常生活自立度蓋然性評価(NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価);

        /**
         * 認知症高齢者日常生活自立度についての蓋然性評価率を、引数から設定します。
         *
         * @param 認知症高齢者日常生活自立度蓋然性評価率 認知症高齢者日常生活自立度についての蓋然性評価率
         * @return OthersSetter
         */
        OthersSetter set認知症高齢者日常生活自立度蓋然性評価率(int 認知症高齢者日常生活自立度蓋然性評価率);

        /**
         * 一次判定結果送付区分を、引数から設定します。
         *
         * @param 一次判定結果送付状況 一次判定結果送付状況
         * @return OthersSetter
         */
        OthersSetter set一次判定結果送付状況(IchijiHanteiResultSofu 一次判定結果送付状況);

        /**
         * 設定した情報を元に、一次判定結果の詳細情報を生成して返します。
         *
         * @return 一次判定結果詳細
         */
        IchijiHanteiResultDetail build();
    }
}
