/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.jushoedit;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.jusho.KannaiKangaiKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護住所編集クラス。
 *
 * @reamsid_L DBA-1290-030 zhengshukai
 */
public class KaigoJushoEditor {

    private static final RString 帳票独自 = new RString("1");
    private static final RString 市町村共通 = new RString("0");
    private static final RString 表示する = new RString("1");
    private static final RString 表示なし = new RString("0");
    private static final RString 編集方法_1 = new RString("1");
    private static final RString 編集方法_2 = new RString("2");
    private static final RString 編集方法_3 = new RString("3");
    private static final RString 編集方法_4 = new RString("4");
    private final ShichosonSecurityJohoFinder shichosonSecurityJohoFinder;
    private final DbT7065ChohyoSeigyoKyotsuDac dbt7065dac;

    /**
     * コンストラクタです。
     */
    public KaigoJushoEditor() {
        this.shichosonSecurityJohoFinder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        this.dbt7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param shichosonSecurityJoho ShichosonSecurityJohoFinder
     */
    KaigoJushoEditor(ShichosonSecurityJohoFinder shichosonSecurityJohoFinder, DbT7065ChohyoSeigyoKyotsuDac dbt7065dac) {
        this.shichosonSecurityJohoFinder = shichosonSecurityJohoFinder;
        this.dbt7065dac = dbt7065dac;
    }

    /**
     * 管内・管外区分やDBU業務コンフィグ上の住所編集項目・市町村セキュリティマスタの値を元に住所編集を行い、編集結果を文字列として返します。
     *
     * @param 住所クラス IJusho
     * @param subGyomuCode SubGyomuCode
     * @param 帳票分類ID RString
     * @return 住所を表す文字列
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public RString create編集後住所(IJusho 住所クラス, SubGyomuCode subGyomuCode, RString 帳票分類ID) throws NullPointerException {
        requireNonNull(住所クラス, UrSystemErrorMessages.値がnull.getReplacedMessage("住所クラス"));
        RString 住所を表す文字列;
        if (KannaiKangaiKubunType.管内.code().equals(住所クラス.get管内管外().code())) {
            住所を表す文字列 = 導入形態を判断(subGyomuCode, 帳票分類ID, 住所クラス);
        } else {
            住所を表す文字列 = 住所クラス.get住所();
        }
        return 住所を表す文字列;
    }

    private RString 導入形態を判断(SubGyomuCode subGyomuCode, RString 帳票分類ID, IJusho 住所クラス) {
        RString 住所 = RString.EMPTY;
        ShichosonSecurityJoho shichosonSecurity = shichosonSecurityJohoFinder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonSecurity != null) {
            if (DonyuKeitaiCode.事務単一.getCode().equals(shichosonSecurity.get導入形態コード().getCode())
                    || DonyuKeitaiCode.認定単一.getCode().equals(shichosonSecurity.get導入形態コード().getCode())) {
                住所 = 単一市町村の住所編集処理(subGyomuCode, 帳票分類ID, 住所クラス);
            }
            if (DonyuKeitaiCode.事務広域.getCode().equals(shichosonSecurity.get導入形態コード().getCode())
                    || DonyuKeitaiCode.事務構成市町村.getCode().equals(shichosonSecurity.get導入形態コード().getCode())
                    || DonyuKeitaiCode.認定広域.getCode().equals(shichosonSecurity.get導入形態コード().getCode())) {
                住所 = 広域構成市町村の住所編集処理(shichosonSecurity, 住所クラス);
            }
        }
        return 住所;
    }

    private RString 単一市町村の住所編集処理(SubGyomuCode subGyomuCode, RString 帳票分類ID, IJusho 住所クラス) {
        RStringBuilder 単一住所builder = new RStringBuilder();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = dbt7065dac.selectByKey(subGyomuCode, new ReportId(帳票分類ID));
        RString 管内住所編集_都道府県名付与有無 = 表示なし;
        RString 管内住所編集_郡名付与有無 = 表示なし;
        RString 管内住所編集_市町村名付与有無 = 表示なし;
        RString 管内住所編集_編集方法 = 表示なし;
        RString 住所編集_方書表示有無 = 表示なし;
        if (帳票独自.equals(帳票制御共通.getJushoHenshuKubun())) {
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                管内住所編集_都道府県名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                管内住所編集_郡名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                管内住所編集_市町村名付与有無 = 表示する;
            }
            //TODO テーブル「rgdb."DbT7065ChohyoSeigyoKyotsu"」で「住所編集町域表示有無」が存在しない。　QA:1005 2016/03/29
//            管内住所編集_編集方法 = 帳票制御共通. 住所編集町域表示有無
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                住所編集_方書表示有無 = 表示する;
            }
        }
        if (市町村共通.equals(帳票制御共通.getJushoHenshuKubun())) {
            管内住所編集_都道府県名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告);
            管内住所編集_郡名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            管内住所編集_市町村名付与有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告);
            管内住所編集_編集方法 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            住所編集_方書表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        }
        Association accociation = AssociationFinderFactory.createInstance().getAssociation();
        if (表示する.equals(管内住所編集_都道府県名付与有無)) {
            単一住所builder.append(accociation.get都道府県名());
        }
        if (表示する.equals(管内住所編集_郡名付与有無)) {
            単一住所builder.append(accociation.get郡名());
        }
        if (表示する.equals(管内住所編集_市町村名付与有無)) {
            単一住所builder.append(accociation.get市町村名());
        }
        if (編集方法_1.equals(管内住所編集_編集方法)) {
            単一住所builder.append(住所クラス.get住所());
            単一住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
        }
        if (編集方法_2.equals(管内住所編集_編集方法)) {
            //TODO 「住所クラス」で「get行政区画()」が存在しない。　QA:1005 2016/03/29
//            住所を表す文字列に、住所クラスが持つ行政区を追加する（行政区の名称は、住所クラス.get行政区画().getGyoseiku().get名称()で取得できる）。
            単一住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
        }
        if (編集方法_3.equals(管内住所編集_編集方法)) {
            単一住所builder.append(住所クラス.get住所());
            単一住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
            単一住所builder.append(new RString("と"));
            //TODO 「住所クラス」で「get行政区画()」が存在しない。　QA:1005 2016/03/29
//            住所を表す文字列に、住所クラスが持つ行政区を追加する。また、追加前に行政区の前後に"（"と"）"を文字列で付与する。
            単一住所builder.append(new RString("と"));
        }
        if (編集方法_4.equals(管内住所編集_編集方法)) {
            単一住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
        }
        if (表示する.equals(住所編集_方書表示有無)) {
            単一住所builder.append(new RString(" "));
            単一住所builder.append(住所クラス.get方書().getColumnValue());
        }
        return 単一住所builder.toRString();
    }

    private RString 広域構成市町村の住所編集処理(ShichosonSecurityJoho shichosonSecurity, IJusho 住所クラス) {
        RStringBuilder 広域住所builder = new RStringBuilder();
        RString 帳票用都道府県名称表示有無;
        RString 帳票用郡名称表示有無;
        RString 帳票用市町村名称表示有無;
        RString 帳票用住所編集方法;
        RString 帳票用方書表示有無;
        //TODO どんな状況で業務コンフィグの代わりに以下の要素を使用する。 QA:1005 2016/03/29
        if (shichosonSecurity.is支所管理有無フラグ()) {
            帳票用都道府県名称表示有無 = shichosonSecurity.get市町村情報().get帳票用都道府県名称表示有無();
            帳票用郡名称表示有無 = shichosonSecurity.get市町村情報().get帳票用郡名称表示有無();
            帳票用市町村名称表示有無 = shichosonSecurity.get市町村情報().get帳票用市町村名称表示有無();
            帳票用住所編集方法 = shichosonSecurity.get市町村情報().get帳票用住所編集方法();
            帳票用方書表示有無 = shichosonSecurity.get市町村情報().get帳票用方書表示有無();
        } else {
            帳票用都道府県名称表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告);
            帳票用郡名称表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告);
            帳票用市町村名称表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告);
            帳票用住所編集方法 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            帳票用方書表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        }
        if (表示する.equals(帳票用都道府県名称表示有無)) {
            広域住所builder.append(shichosonSecurity.get市町村情報().get都道府県名称());
        }
        if (表示する.equals(帳票用郡名称表示有無)) {
            広域住所builder.append(shichosonSecurity.get市町村情報().get郡名称());
        }
        if (表示する.equals(帳票用市町村名称表示有無)) {
            広域住所builder.append(shichosonSecurity.get市町村情報().get市町村名());
        }
        if (編集方法_1.equals(帳票用住所編集方法)) {
            広域住所builder.append(住所クラス.get住所());
            広域住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
        }
        if (編集方法_2.equals(帳票用住所編集方法)) {
            //TODO 「住所クラス」で「get行政区画()」が存在しない。　QA:1005 2016/03/29
//            住所を表す文字列に、住所クラスが持つ行政区を追加する（行政区の名称は、住所クラス.get行政区画().getGyoseiku().get名称()で取得できる）。
            広域住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
        }
        if (編集方法_3.equals(帳票用住所編集方法)) {
            広域住所builder.append(住所クラス.get住所());
            広域住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
            広域住所builder.append(new RString("と"));
            //TODO 「住所クラス」で「get行政区画()」が存在しない。　QA:1005 2016/03/29
//            住所を表す文字列に、住所クラスが持つ行政区を追加する。また、追加前に行政区の前後に"（"と"）"を文字列で付与する。
            広域住所builder.append(new RString("と"));
        }
        if (編集方法_4.equals(帳票用住所編集方法)) {
            広域住所builder.append(住所クラス.get番地().getBanchi().getColumnValue());
        }
        if (表示する.equals(帳票用方書表示有無)) {
            広域住所builder.append(new RString(" "));
            広域住所builder.append(住所クラス.get方書().getColumnValue());
        }
        return 広域住所builder.toRString();
    }
}
