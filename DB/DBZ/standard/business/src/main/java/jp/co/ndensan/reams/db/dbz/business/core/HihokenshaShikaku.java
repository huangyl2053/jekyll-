/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoShikaku;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険被保険者の資格(異動)を扱います。<br />
 * このクラスの生成には、{@link HihokenshaShikaku.Builder Builder}を用いてください。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public final class HihokenshaShikaku implements IHihokenshaShikaku {

    private final IKaigoShikaku kaigoShikaku;
    private final LasdecCode lasdecCode;
    private final ShikibetsuCode shikibetsuCode;
    private final YMDHMS shoriTimeStamp;
    private final HihokenshaNo hihokenshaNo;
    private final HihokenshaKubun hihokenshaKubun;
    private final ShikakuShutoku shikakuShutoku;
    private final ShikakuSoshitsu shikakuSoshitsu;
    private final ShikakuHenko shikakuHenko;
    private final JushochitokureiTekiyo jutokuTekiyo;
    private final JushochitokureiKaijo jutokuKaijo;
    private final JushochiTokureishaKubun jutokushaKubun;
    private final KoikinaiJushochitokureishaKubun koikinaiJutokushaKubun;
    private final ShoKisaiHokenshaNo koikiJutokuOriginLasdecCode;
    private final LasdecCode oldLasdecCode;
    private final HihokenshashoSaikofu saikofu;
    private final FlexibleDate ichigoGaitoDate;

    private HihokenshaShikaku(Builder builder) {
        this.lasdecCode = builder.theLasdecCode;
        this.kaigoShikaku = builder.kaigoShikaku;
        this.shikibetsuCode = builder.theShikibetsuCode;
        this.shoriTimeStamp = builder.shoriTimestamp;
        this.hihokenshaNo = builder.theHihokenshaNo;
        this.hihokenshaKubun = builder.hihokenshaKubun;
        this.shikakuShutoku = builder.shutoku;
        this.shikakuSoshitsu = builder.soshitsu;
        this.shikakuHenko = builder.henko;
        this.jutokuTekiyo = builder.jutokuTekiyo;
        this.jutokuKaijo = builder.jutokuKaijo;
        this.jutokushaKubun = builder.jutokushaKubun;
        this.koikinaiJutokushaKubun = builder.koikiJutokushaKubun;
        this.koikiJutokuOriginLasdecCode = builder.koikiJutokuOriginHokenshaCode;
        this.oldLasdecCode = builder.theOldLasdecCode;
        this.saikofu = builder.saikofu;
        this.ichigoGaitoDate = builder.ichigoGaitoDate;
    }

    @Override
    public LasdecCode get市町村コード() {
        return this.lasdecCode;
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return this.shikibetsuCode;
    }

    @Override
    public YMDHMS get処理日時() {
        return this.shoriTimeStamp;
    }

    @Override
    public HihokenshaNo get被保険者番号() {
        return this.hihokenshaNo;
    }

    @Override
    public FlexibleDate get第一号年齢到達日() {
        return this.ichigoGaitoDate;
    }

    @Override
    public HihokenshaKubun get被保険者区分() {
        return this.hihokenshaKubun;
    }

    @Override
    public boolean has被保険者資格At(RDate baseDate) {
//TODO n8235 船山　 this.kaigoShikaku.is資格あり()が消えているため、コメントアウトしfalseを返すよう暫定対応。
//        return this.kaigoShikaku.is資格あり(baseDate);
        return false;
    }

    @Override
    public ShikakuShutoku get資格取得() {
        return this.shikakuShutoku;
    }

    @Override
    public ShikakuSoshitsu get資格喪失() {
        return this.shikakuSoshitsu;
    }

    @Override
    public ShikakuHenko get資格変更() {
        return this.shikakuHenko;
    }

    @Override
    public JushochitokureiTekiyo get住所地特例適用() {
        return this.jutokuTekiyo;
    }

    @Override
    public JushochitokureiKaijo get住所地特例解除() {
        return this.jutokuKaijo;
    }

    @Override
    public JushochiTokureishaKubun get住所地特例者区分() {
        return this.jutokushaKubun;
    }

    @Override
    public KoikinaiJushochitokureishaKubun get広域内住所地特例者区分() {
        return this.koikinaiJutokushaKubun;
    }

    @Override
    public ShoKisaiHokenshaNo get広域内住所地特例措置元保険者番号() {
        return this.koikiJutokuOriginLasdecCode;
    }

    @Override
    public LasdecCode get旧市町村コード() {
        return this.oldLasdecCode;
    }

    @Override
    public HihokenshashoSaikofu get被保険者証再交付() {
        return this.saikofu;
    }

    @Override
    public IKaigoShikaku toKaigoShikaku() {
        return this.kaigoShikaku;
    }

    /**
     * 資格異動区分を判定します。<br />
     * 資格喪失、資格変更がないときは、それぞれの実行日が、{@link FlexibleDate#MAX FlexibleDate.MAX}であることを前提に判定します。
     * 資格変更よりも資格喪失を優先して判定します。
     *
     * @return 資格異動区分
     */
//    private ShikakuIdoKubun judgeShikakuIdoKubun() {
//        FlexibleDate 資格変更日 = this.get資格変更().getActionDate();
//        FlexibleDate 資格喪失日 = this.get資格喪失().getActionDate();
//        if (資格喪失日 != FlexibleDate.MAX) {
//            return ShikakuIdoKubun.資格喪失;
//        } else if (資格変更日 != FlexibleDate.MAX) {
//            return ShikakuIdoKubun.資格変更;
//        }
//        return ShikakuIdoKubun.資格取得;
//    }
    /**
     * HihokenshaShikakuを生成するためのクラスです。
     */
    public static class Builder {

        private final LasdecCode theLasdecCode;
        private final ShikibetsuCode theShikibetsuCode;
        private final YMDHMS shoriTimestamp;
        private final HihokenshaKubun hihokenshaKubun;
        private final FlexibleDate ichigoGaitoDate;
        private IKaigoShikaku kaigoShikaku;
        private HihokenshaNo theHihokenshaNo = HihokenshaNo.EMPTY;
        private ShikakuShutoku shutoku = ShikakuShutoku.NOTHING;
        private ShikakuSoshitsu soshitsu = ShikakuSoshitsu.NONE;
        private ShikakuHenko henko = ShikakuHenko.NOTHING;
        private JushochitokureiTekiyo jutokuTekiyo = JushochitokureiTekiyo.NOTHING;
        private JushochitokureiKaijo jutokuKaijo = JushochitokureiKaijo.NOTHING;
        private JushochiTokureishaKubun jutokushaKubun = JushochiTokureishaKubun.通常資格者;
        private KoikinaiJushochitokureishaKubun koikiJutokushaKubun = KoikinaiJushochitokureishaKubun.通常資格者;
        private ShoKisaiHokenshaNo koikiJutokuOriginHokenshaCode = ShoKisaiHokenshaNo.EMPTY;
        private LasdecCode theOldLasdecCode = null;
        private HihokenshashoSaikofu saikofu = HihokenshashoSaikofu.NOTHING;

        /**
         * 既存の{@link IHihokenshaShikaku IHihokenshaShikaku}から、Builderを生成します。
         *
         * @param 被保険者資格 {@link IHihokenshaShikaku 被保険者資格}
         * @throws NullPointerException 引数がnullのとき。
         */
        public Builder(IHihokenshaShikaku 被保険者資格) throws NullPointerException {
            requireNonNull(被保険者資格, errorMessageForE00003With("被保険者資格", simpleNameOf(IHihokenshaShikaku.class)));
            this.theLasdecCode = 被保険者資格.get市町村コード();
            this.theShikibetsuCode = 被保険者資格.get識別コード();
            this.shoriTimestamp = 被保険者資格.get処理日時();
            this.hihokenshaKubun = 被保険者資格.get被保険者区分();
            this.ichigoGaitoDate = 被保険者資格.get第一号年齢到達日();
            this.kaigoShikaku = 被保険者資格.toKaigoShikaku();
            this.theHihokenshaNo = 被保険者資格.get被保険者番号();
            this.shutoku = 被保険者資格.get資格取得();
            this.soshitsu = 被保険者資格.get資格喪失();
            this.henko = 被保険者資格.get資格変更();
            this.jutokuTekiyo = 被保険者資格.get住所地特例適用();
            this.jutokuKaijo = 被保険者資格.get住所地特例解除();
            this.jutokushaKubun = 被保険者資格.get住所地特例者区分();
            this.koikiJutokushaKubun = 被保険者資格.get広域内住所地特例者区分();
            this.koikiJutokuOriginHokenshaCode = 被保険者資格.get広域内住所地特例措置元保険者番号();
            this.theOldLasdecCode = 被保険者資格.get旧市町村コード();
            this.saikofu = 被保険者資格.get被保険者証再交付();
        }

        /**
         * 引数の情報を用いて、Builderを生成します。
         *
         * @param 市町村コード {@link LasdecCode 市町村コード}
         * @param 識別コード {@link ShikibetsuCode 識別コード}
         * @param 処理日時 {@link YMDHMS 被保険者台帳登録日時}
         * @param 被保険者区分 {@link ShikakuHihokenshaKubun 被保険者区分}
         * @param 第1号年齢到達日 {@link FlexibleDate 第1号年齢到達日}
         * @param 資格取得 {@link ShikakuShutoku 資格取得}
         * @throws NullPointerException 引数にnullの項目があるとき。
         */
        public Builder(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時,
                HihokenshaKubun 被保険者区分, FlexibleDate 第1号年齢到達日, ShikakuShutoku 資格取得) throws NullPointerException {
            this(市町村コード, 識別コード, 処理日時, 被保険者区分, 第1号年齢到達日);

            this.shutoku = requireNonNull(資格取得, errorMessageForE00003With("資格取得", simpleNameOf(ShikakuShutoku.class)));
        }

        /**
         * {@link IKaigoShikaku 介護資格}を用いて、Builderを生成します。
         *
         * @param 市町村コード {@link LasdecCode 市町村コード}
         * @param 介護資格 {@link IKaigoShikaku 介護資格}
         * @param 識別コード {@link ShikibetsuCode 識別コード}
         * @param 処理日時 {@link RDateTime 被保険者台帳登録日時}
         * @param 被保険者区分 {@link ShikakuHihokenshaKubun 被保険者区分}
         * @throws NullPointerException 引数にnullの項目があるとき。
         */
        public Builder(IKaigoShikaku 介護資格, LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時,
                HihokenshaKubun 被保険者区分) throws NullPointerException {
            this(市町村コード, 識別コード, 処理日時, 被保険者区分,
                    toFlexibleDate(requireNonNullForKaigoShikaku(介護資格).get一号該当日()));
            this.kaigoShikaku = 介護資格;
            initializeFromKaigoShikaku();
        }

        private static IKaigoShikaku requireNonNullForKaigoShikaku(IKaigoShikaku kaigoShikaku) {
            return (IKaigoShikaku) requireNonNull(kaigoShikaku, errorMessageForE00003With("介護資格", simpleNameOf(IKaigoShikaku.class)));
        }

        /**
         * 共通privateコンストラクタです。
         *
         * @param 市町村コード {@link LasdecCode 市町村コード}
         * @param 識別コード {@link ShikibetsuCode 識別コード}
         * @param 処理日時 {@link RDateTime 被保険者台帳登録日時}
         * @param 被保険者区分 {@link ShikakuHihokenshaKubun 被保険者区分}
         * @param 第1号年齢到達日 {@link FlexibleDate 第1号年齢到達日}
         */
        private Builder(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時,
                HihokenshaKubun 被保険者区分, FlexibleDate 第1号年齢到達日) {
            this.theLasdecCode = requireNonNull(市町村コード, errorMessageForE00003With("市町村コード", simpleNameOf(LasdecCode.class)));
            this.theShikibetsuCode = requireNonNull(識別コード, errorMessageForE00003With("識別コード", simpleNameOf(ShikibetsuCode.class)));
            this.shoriTimestamp = requireNonNull(処理日時, errorMessageForE00003With("処理日時", simpleNameOf(YMDHMS.class)));
            this.hihokenshaKubun = requireNonNull(被保険者区分, errorMessageForE00003With("被保険者区分", simpleNameOf(HihokenshaKubun.class)));
            this.ichigoGaitoDate = requireNonNull(第1号年齢到達日, errorMessageForE00003With("第1号年齢到達日", simpleNameOf(FlexibleDate.class)));
        }

        /**
         * 被保険者資格を生成します。<br />
         * 生成したHihokenshaShikakuの{@link HihokenshaShikaku#toKaigoShikaku() toKaigoShikaku()}で得られるオブジェクトは、
         * もしBuilderの生成にIKaigoShikakuオブジェクトを渡していたとしても、そのオブジェクトと異なる結果を持つことがあります。
         * それは、Builderによる生成過程で{@link HihokenshaShikaku.Builder#soshitsu shikakuSoshitsu}等のメソッドにより、
         * コンストラクタが受け取ったIKaigoShikakuが保持する物と異なる値が設定される可能性があるからです。
         * 生整過程での設定内容と生成後のオブジェクトとの整合性をとるために、このメソッドで、IKaigoShikakuは再計算されます。
         *
         * @return {@link HihokenshaShikaku HihokenshaShikaku}
         */
        public HihokenshaShikaku build() {
            calculateKaigoShikakuFromMember();
            return new HihokenshaShikaku(this);
        }

        /**
         * 被保険者番号を設定します。
         *
         * @param hihokenshaNo {@link HihokenshaNo 被保険者番号}
         * @return 被保険者番号を設定したBuilder自身
         */
        public Builder hihokenshaNo(HihokenshaNo hihokenshaNo) {
            this.theHihokenshaNo = hihokenshaNo;
            return this;
        }

        /**
         * 資格取得を設定します。
         *
         * @param shikakuShutoku {@link ShikakuShutoku 資格取得}
         * @return 資格取得を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder shikakuShutoku(ShikakuShutoku shikakuShutoku) throws IllegalArgumentException {
            if (isNull(shikakuShutoku)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(ShikakuShutoku.class)));
            }
            this.shutoku = shikakuShutoku;
            return this;
        }

        /**
         * 資格喪失を設定します。
         *
         * @param shikakuSoshitsu {@link ShikakuSoshitsu 資格喪失}
         * @return 資格喪失を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder shikakuSoshitsu(ShikakuSoshitsu shikakuSoshitsu) throws IllegalArgumentException {
            if (isNull(shikakuSoshitsu)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(ShikakuSoshitsu.class)));
            }
            this.soshitsu = shikakuSoshitsu;
            return this;
        }

        /**
         * 資格変更を設定します。
         *
         * @param shikakuHenko {@link ShikakuHenko 資格変更}
         * @return 資格変更を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。。
         */
        public Builder shikakuHenko(ShikakuHenko shikakuHenko) throws IllegalArgumentException {
            if (isNull(shikakuHenko)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(ShikakuHenko.class)));
            }
            this.henko = shikakuHenko;
            return this;
        }

        /**
         * 住所地特例適用を設定します。
         *
         * @param jutokuTekiyo {@link JushochitokureiTekiyo 住所地特例適用}
         * @return 住所地特例適用を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder jushochitokureiTekiyo(JushochitokureiTekiyo jutokuTekiyo) throws IllegalArgumentException {
            if (isNull(jutokuTekiyo)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(JushochitokureiTekiyo.class)));
            }
            this.jutokuTekiyo = jutokuTekiyo;
            return this;
        }

        /**
         * 住所地特例解除を設定します。
         *
         * @param jutokuKaijo {@link JushochitokureiKaijo 住所地特例解除}
         * @return 住所地特例解除を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder jushochitokureiKaijo(JushochitokureiKaijo jutokuKaijo) throws IllegalArgumentException {
            if (isNull(jutokuKaijo)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(JushochitokureiKaijo.class)));
            }
            this.jutokuKaijo = jutokuKaijo;
            return this;
        }

        /**
         * 住所地特例者区分を設定します。
         *
         * @param kubun {@link JushochiTokureishaKubun 住所地特例者区分}
         * @return 住所地特例者区分を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder jushochiTokureishaKubun(JushochiTokureishaKubun kubun) throws IllegalArgumentException {
            if (isNull(kubun)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(JushochiTokureishaKubun.class)));
            }
            this.jutokushaKubun = kubun;
            return this;
        }

        /**
         * 広域内住所地特例者区分を設定します。
         *
         * @param kubun {@link KoikinaiJushochitokureishaKubun 広域内住所地特例者区分}
         * @return 広域内住所地特例者区分を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder koikinaiJushochiTokureishaKubun(KoikinaiJushochitokureishaKubun kubun) throws IllegalArgumentException {
            if (isNull(kubun)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(KoikinaiJushochitokureishaKubun.class)));
            }
            this.koikiJutokushaKubun = kubun;
            return this;
        }

        /**
         * 広域内住所地特例措置元保険者番号を設定します。
         *
         * @param shoKisaiHokenshaNo {@link ShoKisaiHokenshaNo 証記載保険者番号}
         * @return 広域内住所地特例措置元保険者番号を設定したBuilder自身
         */
        public Builder koikinaiJutokuSochimotoLasdecCode(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
            this.koikiJutokuOriginHokenshaCode = shoKisaiHokenshaNo;
            return this;
        }

        /**
         * 合併前旧市町村コードを設定します。
         *
         * @param lasdecCode {@link LasdecCode 地方公共団体コード}
         * @return 合併前旧市町村コードを設定したBuilder自身
         */
        public Builder oldLasdecCode(LasdecCode lasdecCode) {
            this.theOldLasdecCode = lasdecCode;
            return this;
        }

        /**
         * 被保険者証再交付を設定します。
         *
         * @param saikofu {@link HihokenshashoSaikofu 被保険者証再交付}
         * @return 被保険者証再交付を設定したBuilder自身
         * @throws IllegalArgumentException 引数がnullのとき。
         */
        public Builder hihokenshashoSaikofu(HihokenshashoSaikofu saikofu) throws IllegalArgumentException {
            if (isNull(saikofu)) {
                throw new IllegalArgumentException(errorMessageForE00001With(simpleNameOf(HihokenshashoSaikofu.class)));
            }
            this.saikofu = saikofu;
            return this;
        }

        private static String simpleNameOf(Class clazz) {
            return clazz.getSimpleName();
        }

        private static String errorMessageForE00003With(String name, String className) {
            return errorMessageForE00003With(name + "(" + className + ")");
        }

        private static String errorMessageForE00003With(String str) {
            return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(str, Builder.class.getSimpleName());
        }

        private static String errorMessageForE00001With(String str) {
            return UrSystemErrorMessages.値がnull.getReplacedMessage(str);
        }

        private void initializeFromKaigoShikaku() {
            this.theHihokenshaNo = createKaigoHihokenshaNo();
            this.shutoku = createShikakuShutoku();
            this.soshitsu = createShikakuSoshitsu();
        }

        private HihokenshaNo createKaigoHihokenshaNo() {
            RString value = this.kaigoShikaku.get被保険者番号();
            if (isNull(value)) {
                return null;
            }
            return new HihokenshaNo(value);
        }

        private ShikakuShutoku createShikakuShutoku() {
//            this.kaigoShikakuのメソッドがなくなっているため、コメントアウトし代わりに値をセット
//            ShikakuShutokuJiyu cause = toShikakuShutokuJiyu(this.kaigoShikaku.get資格取得事由().getCode().value());
//            FlexibleDate noticeDate = toFlexibleDate(this.kaigoShikaku.get資格取得届出年月日());
//            FlexibleDate actionDate = toFlexibleDate(this.kaigoShikaku.get資格取得年月日());
            ShikakuShutokuJiyu cause = ShikakuShutokuJiyu.その他;
            FlexibleDate noticeDate = new FlexibleDate("20140402");
            FlexibleDate actionDate = new FlexibleDate("20140403");
            return new ShikakuShutoku(cause, noticeDate, actionDate);
        }

        private ShikakuShutokuJiyu toShikakuShutokuJiyu(RString code) {
            return ShikakuShutokuJiyu.toValue(code);
        }

        private ShikakuSoshitsu createShikakuSoshitsu() {
//            this.kaigoShikakuのメソッドがなくなっているため、コメントアウト代わりに値をセット
//            ShikakuSoshitsuJiyu cause = toShikakuSoshitsuJiyu(this.kaigoShikaku.get資格喪失事由().getCode().value());
//            FlexibleDate noticeDate = toFlexibleDate(this.kaigoShikaku.get資格喪失届出年月日());
//            FlexibleDate actionDate = toFlexibleDate(this.kaigoShikaku.get資格喪失年月日());
            ShikakuSoshitsuJiyu cause = ShikakuSoshitsuJiyu.その他;
            FlexibleDate noticeDate = new FlexibleDate("20140404");
            FlexibleDate actionDate = new FlexibleDate("20140405");
            return new ShikakuSoshitsu(cause, noticeDate, actionDate);
        }

        private ShikakuSoshitsuJiyu toShikakuSoshitsuJiyu(RString code) {
            return ShikakuSoshitsuJiyu.toValue(code);
        }

        private void calculateKaigoShikakuFromMember() {
//            IKaigoShikaku shikaku = KaigoShikakuFactory.createInstance(
//                    this.theShikibetsuCode, HokenShubetsu.介護保険,
//                    toRDateOrMin(this.shutoku.getNoticeDate()),
//                    toRDateOrMin(this.shutoku.getActionDate()),
//                    //クラスが削除されてしまっているため、このクラスをどうするか決める必要がある。
//                    //                    toIShikakuShutokuJiyu(this.shutoku.getReason().getCode()),
//                    null,
//                    toRDateOrMax(this.soshitsu.getNoticeDate()),
//                    toRDateOrMax(this.soshitsu.getActionDate()),
//                    //                    toIShikakuSoshitsuJiyu(this.soshitsu.getReason().getCode()),
//                    //クラスが削除されてしまっているため、このクラスをどうするか決める必要がある。
//                    null,
//                    this.theHihokenshaNo.value(),
//                    this.koikiJutokuOriginHokenshaCode.value(),
//                    toRDateOrMax(this.ichigoGaitoDate),
//                    toShikakuHihokenshaKubun(this.hihokenshaKubun),
//                    this.jutokushaKubun);
//            this.kaigoShikaku = shikaku;
        }

        //TODO n8178 城間篤人 UR側の区分も今後、CodeAssignedItemの形に修正する予定。修正後にこのメソッドを削除する　2014年9月末
//        private ShikakuHihokenshaKubun toShikakuHihokenshaKubun(HihokenshaKubun hihokenshaKubun) {
//            return ShikakuHihokenshaKubun.第１号被保険者;
//        }
        private boolean isNull(Object target) {
            return target == null;
        }

        private static FlexibleDate toFlexibleDate(RDate date) {
            return new FlexibleDate(date.toString());
        }

        private RDate toRDateOrMin(FlexibleDate date) {
            return date.isValid() ? _toRDate(date) : RDate.MIN;
        }

        private RDate toRDateOrMax(FlexibleDate date) {
            return date.isValid() ? _toRDate(date) : RDate.MAX;
        }

        private RDate _toRDate(FlexibleDate date) {
            return new RDate(date.toString());
        }

//        private IShikakuShutokuJiyu toIShikakuShutokuJiyu(RString code) {
//            final ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.toValue(code);
//            return new IShikakuShutokuJiyu() {
//                @Override
//                public RString getCode() {
//                    return reason.getCode();
//                }
//
//                @Override
//                public RString getName() {
//                    return reason.getName();
//                }
//
//                @Override
//                public RString getShortName() {
//                    return reason.getShortName();
//                }
//            };
//        }
//        private IShikakuSoshitsuJiyu toIShikakuSoshitsuJiyu(RString code) {
//            final ShikakuSoshitsuJiyu reason = ShikakuSoshitsuJiyu.toValue(code);
//            return new IShikakuSoshitsuJiyu() {
//                @Override
//                public RString getCode() {
//                    return reason.getCode();
//                }
//
//                @Override
//                public RString getName() {
//                    return reason.getName();
//                }
//
//                @Override
//                public RString getShortName() {
//                    return reason.getShortName();
//                }
//            };
//        }
    }
}
