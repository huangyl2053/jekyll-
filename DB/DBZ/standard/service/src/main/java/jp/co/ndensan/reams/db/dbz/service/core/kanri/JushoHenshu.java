package jp.co.ndensan.reams.db.dbz.service.core.kanri;

import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
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
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住所編集のクラスです。
 *
 * @reamsid_L DBB-9030-010 wangxiaodong
 */
public class JushoHenshu {

    private static final RString 管内 = new RString("1");
    private final DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac;

    /**
     * コンストラクタです。
     */
    public JushoHenshu() {
        this.dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7065Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    JushoHenshu(DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac) {
        this.dbT7065Dac = dbT7065Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JushoHenshu}のインスタンスを返します。
     *
     * @return JushoHenshu
     */
    public static JushoHenshu createInstance() {
        return InstanceProvider.create(JushoHenshu.class);
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 宛名情報 宛名情報
     * @return 帳票制御共通情報
     */
    public RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IShikibetsuTaisho 宛名情報) {
        JushoEditorBuilder jushoEditorBuilder = new JushoEditorBuilder(宛名情報.get住所());
        jushoEditorBuilder.set管内住所接頭辞(getJushoPrefix(帳票共通情報),
                AssociationFinderFactory.createInstance().getAssociation());
        set管内住所編集パターン(jushoEditorBuilder, 帳票共通情報);
        jushoEditorBuilder.set管外住所編集パターン(getJushoKangaiEditPattern(帳票共通情報));
        jushoEditorBuilder.set行政区(宛名情報.get行政区画().getGyoseiku());

        return jushoEditorBuilder.build().editJusho().get編集後住所All();
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 個人 個人
     * @return 帳票制御共通情報
     */
    public RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IKojin 個人) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 個人.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報);
    }

    /**
     * 宛名の情報によって、住所2を編集します。
     *
     * @param 住所 住所
     * @param 番地 番地
     * @return 住所2
     */
    public RString editJusho2(AtenaJusho 住所, AtenaBanchi 番地) {
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
    public RString editJusho2(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        住所 = ObjectUtil.defaultIfNull(住所, AtenaJusho.EMPTY);
        番地 = ObjectUtil.defaultIfNull(番地, AtenaBanchi.EMPTY);
        if (方書 == null) {
            return 住所.getColumnValue().concat(番地.getColumnValue());
        }
        return 住所.getColumnValue().concat(番地.getColumnValue()).concat(RString.FULL_SPACE).concat(方書.getColumnValue());
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 法人 法人
     * @return 帳票制御共通情報
     */
    public RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IHojin 法人) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 法人.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報);
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 住基個人 住基個人
     * @return 帳票制御共通情報
     */
    public RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IJukiKojin 住基個人) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 住基個人.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報);
    }

    /**
     * 宛名の情報によって、住所を編集します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @param 共有者 共有者
     * @return 帳票制御共通情報
     */
    public RString editJusho(ChohyoSeigyoKyotsu 帳票共通情報, IKyoyusha 共有者) {
        UaFt200FindShikibetsuTaishoEntity ft200Entity = 共有者.toEntity();
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
        return editJusho(帳票共通情報, 宛名情報);
    }

    /**
     * 帳票分類IDによって、帳票制御共通情報を取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @throws ApplicationException データ存在しない
     * @return 帳票制御共通情報
     */
    public ChohyoSeigyoKyotsu getChohyoSeigyoKyotsuJoho(ReportId 帳票分類ID) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        if (dbT7065Entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("帳票分類ID"));
        }
        dbT7065Entity.initializeMd5();
        return new ChohyoSeigyoKyotsu(dbT7065Entity);
    }

    /**
     * 帳票制御共通情報によって、カスタマバーコード使用有無を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return カスタマバーコード使用有無
     */
    public boolean usesCustomerBarcode(ChohyoSeigyoKyotsu 帳票共通情報) {

        return EditedAtesakiBuilder.usesCustomerBarcode(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、管内住所接頭辞を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管内住所接頭辞
     */
    public JushoPrefix getJushoPrefix(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getJushoPrefix(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、管内住所編集パターンを取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管内住所編集パターン
     */
    public JushoKannaiEditPattern getJushoKannaiEditPattern(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getJushoKannaiEditPattern(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、行政区印字区分を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 行政区印字区分
     */
    public GyoseikuInjiKubun getGyoseikuInjiKubun(ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.getGyoseikuInjiKubun(帳票共通情報);
    }

    /**
     * 帳票制御共通情報によって、管外住所編集パターンを取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管外住所編集パターン
     */
    public JushoKangaiEditPattern getJushoKangaiEditPattern(ChohyoSeigyoKyotsu 帳票共通情報) {
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
    public EditedAtesaki create編集後宛先(
            IAtesaki 宛先,
            Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票共通情報) {
        return EditedAtesakiBuilder.create編集後宛先(宛先, 地方公共団体, 帳票共通情報);
    }

    private void set管内住所編集パターン(JushoEditorBuilder jushoEditorBuilder, ChohyoSeigyoKyotsu 帳票共通情報) {
        JushoKannaiEditPattern 管内住所編集パターン = getJushoKannaiEditPattern(帳票共通情報);
        GyoseikuInjiKubun 行政区印字区分 = getGyoseikuInjiKubun(帳票共通情報);
        if (JushoKannaiEditPattern.町域番地方書.equals(管内住所編集パターン)) {
            if (GyoseikuInjiKubun.括弧付きで印字.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地方書カッコ行政区);
            }
            if (GyoseikuInjiKubun.印字しない.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地方書);
            }
        }
        if (JushoKannaiEditPattern.町域番地.equals(管内住所編集パターン)) {
            if (GyoseikuInjiKubun.括弧付きで印字.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地カッコ行政区);
            }
            if (GyoseikuInjiKubun.印字しない.equals(行政区印字区分)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地);
            }
        }
    }

    /**
     * 住所コードを設定します。
     *
     * @param uaFt200Entity uaFt200Entity
     * @return 住所コード
     */
    public RString get住所コード(UaFt200FindShikibetsuTaishoEntity uaFt200Entity) {
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
}
