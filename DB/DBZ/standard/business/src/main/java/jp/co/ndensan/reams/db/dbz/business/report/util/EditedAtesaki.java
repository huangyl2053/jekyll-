/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.util;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.setainusihyojijoho.SetainusiHyojiJoho;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditor;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyoseikuInjiKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKangaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoPrefix;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.Gyoseiku;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;

/**
 * 編集後宛先のクラスです。
 *
 * @reamsid_L DBB-9040-130 wangxiaodong
 */
public class EditedAtesaki {

    private static final RString 入力郵便番号をセット = new RString("2");
    private static final RString 様方 = new RString("様方");
    private final IAtesaki 宛先;
    private final Association 地方公共団体;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final boolean カスタマバーコード使用有無;
    private final JushoKangaiEditPattern 管外住所編集パターン;
    private final JushoPrefix 管内住所接頭辞;
    private final JushoKannaiEditPattern 管内住所編集パターン;
    private final GyoseikuInjiKubun 行政区印字区分;
    private SofubutsuAtesakiSource 送付物宛先ソース;
    private RString 編集後住所;

    /**
     * コンストラクタです。
     *
     * @param 宛先 宛先
     * @param 地方公共団体 地方公共団体
     * @param 帳票制御共通 帳票制御共通
     */
    public EditedAtesaki(IAtesaki 宛先,
            Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        this.宛先 = requireNonNull(宛先, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先"));
        this.地方公共団体 = requireNonNull(地方公共団体, UrSystemErrorMessages.値がnull.getReplacedMessage("地方公共団体"));
        this.帳票制御共通 = requireNonNull(帳票制御共通, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通"));
        this.カスタマバーコード使用有無 = JushoHenshu.usesCustomerBarcode(帳票制御共通);
        this.管外住所編集パターン = JushoHenshu.getJushoKangaiEditPattern(帳票制御共通);
        this.管内住所編集パターン = JushoHenshu.getJushoKannaiEditPattern(帳票制御共通);
        this.管内住所接頭辞 = JushoHenshu.getJushoPrefix(帳票制御共通);
        this.行政区印字区分 = JushoHenshu.getGyoseikuInjiKubun(帳票制御共通);
    }

    /**
     * 送付物宛先ソースデータを返します。
     *
     * @return 送付物宛先ソースデータ
     */
    public KaigoSofubutsuAtesakiSource getSofubutsuAtesakiSource() {
        AtenaMeisho 世帯主名 = 宛先.toEntity().getSetainushiKanjiShimei();
        RStringBuilder builder世帯主 = new RStringBuilder();
        if (世帯主名 != null) {
            builder世帯主.append(世帯主名.value()).append(様方);
        }
        if (送付物宛先ソース != null) {
            return new KaigoSofubutsuAtesakiSource(送付物宛先ソース, new SetainusiHyojiJoho(
                    帳票制御共通.is世帯主表示有無() ? builder世帯主.toRString() : RString.EMPTY));
        }
        SofubutsuAtesakiEditorBuilder builder = new SofubutsuAtesakiEditorBuilder(宛先);
        builder.setカスタマーバーコード印字有無(カスタマバーコード使用有無);
        builder.set管外住所編集パターン(管外住所編集パターン);
        builder.set管内住所編集パターン(管内住所編集パターン);
        builder.set管内住所接頭辞(管内住所接頭辞, 地方公共団体);
        builder.set行政区印字区分(行政区印字区分);
        builder.set氏名2括弧有無(true);
        builder.set代納区分名印字有無(帳票制御共通.is代納人表示有無());
        SofubutsuAtesakiSource atesakiSource = new SofubutsuAtesakiSourceBuilder(builder.build()).buildSource();
        if (帳票制御共通.isカスタマバーコード使用有無() && atesakiSource.customerBarCode.isEmpty()
                && 入力郵便番号をセット.equals(帳票制御共通.getカスタマバーコード変換エラー編集方法())) {
            atesakiSource.customerBarCode = new CustomerBarCode().convertCustomerBarCode(
                    宛先.get宛先住所().get郵便番号().getYubinNo(), RString.EMPTY).getCustomerBarCode();
        }
        送付物宛先ソース = atesakiSource;
        return new KaigoSofubutsuAtesakiSource(送付物宛先ソース, new SetainusiHyojiJoho(
                帳票制御共通.is世帯主表示有無() ? builder世帯主.toRString() : RString.EMPTY));
    }

    /**
     * 宛先種別を返します。
     *
     * @return 宛先種別
     */
    public AtesakiShubetsu get宛先種別() {
        return 宛先.get宛先種別();
    }

    /**
     * 宛先名称を返します。
     *
     * @return 宛先名称
     */
    public IName get宛先名称() {
        return 宛先.get宛先名称();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get本人識別コード() {
        return 宛先.get識別コード();
    }

    /**
     * 本人名称を返します。
     *
     * @return 本人名称
     */
    public IName get本人名称() {
        return 宛先.get宛先本人名称();
    }

    /**
     * 本人敬称を返します。
     *
     * @return 本人敬称
     */
    public RString get本人敬称() {
        return 宛先.get宛先敬称付与区分().getValue();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return 宛先.get宛先住所().get郵便番号().getEditedYubinNo();
    }

    /**
     * 編集後住所を返します。
     *
     * @return 編集後住所
     */
    public RString get編集後住所() {
        if (!RString.isNullOrEmpty(編集後住所)) {
            return 編集後住所;
        }
        JushoEditorBuilder builder = new JushoEditorBuilder(宛先.get宛先住所());
        builder.set管外住所編集パターン(管外住所編集パターン);
        builder.set管内住所接頭辞(管内住所接頭辞, 地方公共団体);
        builder.set管内住所編集パターン(get管内住所編集パターン());
        builder.set行政区(宛先.get宛先行政区());
        JushoEditor editor = builder.build();
        編集後住所 = editor.editJusho().get編集後住所All();
        return 編集後住所;
    }

    /**
     * 町域を返します。
     *
     * @return 町域
     */
    public RString get町域() {
        return 宛先.get宛先住所().get住所();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public RString get番地() {
        return 宛先.get宛先住所().get番地().getBanchi().value();
    }

    /**
     * 宛先行政区を返します。
     *
     * @return 宛先行政区
     */
    public RString get宛先行政区() {
        return 宛先.get宛先行政区().get名称();
    }

    /**
     * 行政区コードを返します。
     *
     * @return 行政区コード
     */
    public GyoseikuCode get行政区コード() {
        return 宛先.get宛先行政区().getコード();
    }

    /**
     * 全国住所コードを返します。
     *
     * @return 住所コード
     */
    public ZenkokuJushoCode get住所コード() {
        return 宛先.get宛先住所().get全国住所コード();
    }

    /**
     * 宛先の行政区を返します。
     *
     * @return 行政区
     */
    public Gyoseiku get行政区() {
        return 宛先.get宛先行政区();
    }

    /**
     * 方書を返します。
     *
     * @return 方書
     */
    public RString get方書() {
        return 宛先.get宛先住所().get方書().getColumnValue();
    }

    /**
     * 宛先が保持する行政区名を返します。
     *
     * @return 方書
     */
    public RString get行政区名() {
        return 宛先.get宛先行政区().get名称();
    }

    private JushoKannaiEditPattern get管内住所編集パターン() {
        if (JushoKannaiEditPattern.町域番地方書 == 管内住所編集パターン) {
            if (GyoseikuInjiKubun.括弧付きで印字 == 行政区印字区分) {
                return JushoKannaiEditPattern.町域番地方書カッコ行政区;
            } else if (GyoseikuInjiKubun.印字しない == 行政区印字区分) {
                return JushoKannaiEditPattern.町域番地方書;
            }
        } else if (JushoKannaiEditPattern.町域番地 == 管内住所編集パターン) {
            if (GyoseikuInjiKubun.括弧付きで印字 == 行政区印字区分) {
                return JushoKannaiEditPattern.町域番地カッコ行政区;
            } else if (GyoseikuInjiKubun.印字しない == 行政区印字区分) {
                return JushoKannaiEditPattern.町域番地;
            }
        }
        return 管内住所編集パターン;
    }

    /**
     * 管内管外区分を返します。
     *
     * @return 管内管外区分
     */
    public RString get管内管外区分() {
        return 宛先.toEntity().getKannaiKangaiKubun();
    }

    /**
     * 町域コードを返します。
     *
     * @return 町域コード
     */
    public RString get町域コード() {
        return 宛先.get宛先住所().get町域コード().getColumnValue();
    }

    /**
     * 地区１を返します。
     *
     * @return 地区１
     */
    public RString get地区１() {
        return 宛先.get地区１().getコード().getColumnValue();
    }

    /**
     * 地区２を返します。
     *
     * @return 地区２
     */
    public RString get地区２() {
        return 宛先.get地区２().getコード().getColumnValue();
    }

    /**
     * 地区３を返します。
     *
     * @return 地区３
     */
    public RString get地区３() {
        return 宛先.get地区３().getコード().getColumnValue();
    }

    /**
     * 番地コードを返します。
     *
     * @return 番地コード
     */
    public RString get編集番地コード() {
        return 宛先.get宛先住所().get番地().getBanchiCode1().getColumnValue()
                .concat(宛先.get宛先住所().get番地().getBanchiCode2().getColumnValue())
                .concat(宛先.get宛先住所().get番地().getBanchiCode3().getColumnValue())
                .concat(宛先.get宛先住所().get番地().getBanchiCode4().getColumnValue());
    }
}
