package jp.co.ndensan.reams.db.dbz.business.core.kanri;

import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.hojin.IHojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.jukikojin.IJukiKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kyoyusha.IKyoyusha;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyoseikuInjiKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKangaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoPrefix;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所編集のクラスです。
 *
 * @reamsid_L DBB-9030-010 wangxiaodong
 */
public final class JushoHenshu {

    private static final RString 管内 = new RString("1");

    private JushoHenshu() {
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 宛名情報 宛名情報
     * @param 地方公共団体 地方公共団体
     * @return 編集した住所
     */
    public static RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IShikibetsuTaisho 宛名情報, Association 地方公共団体) {
        JushoEditorBuilder jushoEditorBuilder = new JushoEditorBuilder(宛名情報.get住所());
        if (宛名情報.is住登内() && 地方公共団体 != null) {
            jushoEditorBuilder.set管内住所接頭辞(JushoHenshu.getJushoPrefix(帳票共通情報), 地方公共団体);
        }
        set管内住所編集パターン(jushoEditorBuilder, 帳票共通情報);
        jushoEditorBuilder.set管外住所編集パターン(JushoHenshu.getJushoKangaiEditPattern(帳票共通情報));
        jushoEditorBuilder.set行政区(宛名情報.get行政区画().getGyoseiku());

        return jushoEditorBuilder.build().editJusho().get編集後住所All();
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 個人 個人
     * @param 地方公共団体 地方公共団体
     * @return 帳票制御共通情報
     */
    public static RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IKojin 個人, Association 地方公共団体) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 個人.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報, 地方公共団体);
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 法人 法人
     * @param 地方公共団体 地方公共団体
     * @return 帳票制御共通情報
     */
    public static RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IHojin 法人, Association 地方公共団体) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 法人.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報, 地方公共団体);
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 住基個人 住基個人
     * @param 地方公共団体 地方公共団体
     * @return 帳票制御共通情報
     */
    public static RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IJukiKojin 住基個人, Association 地方公共団体) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 住基個人.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報, 地方公共団体);
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 共有者 共有者
     * @param 地方公共団体 地方公共団体
     * @return 帳票制御共通情報
     */
    public static RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IKyoyusha 共有者, Association 地方公共団体) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 共有者.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報, 地方公共団体);
    }

    /**
     * 宛名の情報によって、住所2を編集します。
     *
     * @param 住所 住所
     * @param 番地 番地
     * @return 住所2
     */
    public static RString editJusho2(AtenaJusho 住所, AtenaBanchi 番地) {
        return editJusho2(住所, 番地, null);
    }

    /**
     * 宛名の情報によって、住所2を編集します。
     *
     * @param 住所 住所
     * @param 番地 番地
     * @param 方書 方書
     * @return 住所2
     */
    public static RString editJusho2(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        住所 = ObjectUtil.defaultIfNull(住所, AtenaJusho.EMPTY);
        番地 = ObjectUtil.defaultIfNull(番地, AtenaBanchi.EMPTY);
        if (方書 == null) {
            return 住所.getColumnValue().concat(番地.getColumnValue());
        }
        return 住所.getColumnValue().concat(番地.getColumnValue()).concat(RString.FULL_SPACE).concat(方書.getColumnValue());
    }

    /**
     * 帳票制御共通情報によって、カスタマバーコード使用有無を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return カスタマバーコード使用有無
     */
    public static boolean usesCustomerBarcode(ChohyoSeigyoKyotsu 帳票共通情報) {

        return EditedAtesakiBuilder.usesCustomerBarcode(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、管内住所接頭辞を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管内住所接頭辞
     */
    public static JushoPrefix getJushoPrefix(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getJushoPrefix(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、管内住所編集パターンを取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管内住所編集パターン
     */
    public static JushoKannaiEditPattern getJushoKannaiEditPattern(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getJushoKannaiEditPattern(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、行政区印字区分を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 行政区印字区分
     */
    public static GyoseikuInjiKubun getGyoseikuInjiKubun(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getGyoseikuInjiKubun(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、管外住所編集パターンを取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管外住所編集パターン
     */
    public static JushoKangaiEditPattern getJushoKangaiEditPattern(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getJushoKangaiEditPattern(帳票共通情報);
    }

    /**
     * 編集後宛先を作成します。
     *
     * @param 宛先 宛先
     * @param 地方公共団体 地方公共団体
     * @param 帳票共通情報 帳票共通情報
     * @return 編集後宛先
     */
    public static EditedAtesaki create編集後宛先(
            IAtesaki 宛先,
            Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.create編集後宛先(宛先, 地方公共団体, 帳票共通情報);
    }

    /**
     * 住所コードを設定します。
     *
     * @param uaFt200Entity uaFt200Entity
     * @return 住所コード
     */
    public static RString get住所コード(UaFt200FindShikibetsuTaishoEntity uaFt200Entity) {
        RString 住所コード = RString.EMPTY;
        if (uaFt200Entity != null) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(uaFt200Entity);
            if (管内.equals(uaFt200Entity.getKannaiKangaiKubun())) {
                住所コード = shikibetsuTaisho.to個人().get住所().get町域コード() == null ? RString.EMPTY
                        : shikibetsuTaisho.to個人().get住所().get町域コード().getColumnValue();
            } else {
                住所コード = shikibetsuTaisho.to個人().get住所().get全国住所コード() == null ? RString.EMPTY
                        : shikibetsuTaisho.to個人().get住所().get全国住所コード().getColumnValue();
            }
        }
        return 住所コード;
    }

    private static void set管内住所編集パターン(JushoEditorBuilder jushoEditorBuilder, ChohyoSeigyoKyotsu 帳票共通情報) {
        JushoKannaiEditPattern 管内住所編集パターン = JushoHenshu.getJushoKannaiEditPattern(帳票共通情報);
        GyoseikuInjiKubun 行政区印字区分 = JushoHenshu.getGyoseikuInjiKubun(帳票共通情報);
        if (JushoKannaiEditPattern.町域番地方書.equals(管内住所編集パターン)) {
            if (GyoseikuInjiKubun.括弧付きで印字.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地方書カッコ行政区);
                return;
            }
            if (GyoseikuInjiKubun.印字しない.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地方書);
                return;
            }
        }
        if (JushoKannaiEditPattern.町域番地.equals(管内住所編集パターン)) {
            if (GyoseikuInjiKubun.括弧付きで印字.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地カッコ行政区);
                return;
            }
            if (GyoseikuInjiKubun.印字しない.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地);
                return;
            }
        }
        jushoEditorBuilder.set管内住所編集パターン(管内住所編集パターン);
    }
}
