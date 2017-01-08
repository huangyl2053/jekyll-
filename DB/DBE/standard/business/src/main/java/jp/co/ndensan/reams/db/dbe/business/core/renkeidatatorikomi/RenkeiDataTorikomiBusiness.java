/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5130ShiboEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5101ErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5101KoroshoErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5101KoroshoTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5101TempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5910ErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5910KoroshoErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5911ErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5911KoroshoErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5912ErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5912KoroshoErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5913ErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5913KoroshoErrorTempEUCEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 認定調査データ出力（モバイル）CSVEntity設定のビジネスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class RenkeiDataTorikomiBusiness {

    private static final RString 更新2 = new RString("2");
    private static final RString 登録 = new RString("3");
    private static final RString CODE0 = new RString("0");
    private static final RString CODE1 = new RString("001");
    private static final RString 申請書管理番号_ZERO17 = new RString("00000000000000000");
    private static final int 採番番号桁数 = 5;
    private static RString rstring申請書管理番号;

    /**
     * DbT5912ShujiiIryoKikanJohoEntityの設定メッソドです。
     *
     * @param entity DbT5912RelateEntity
     * @param processParamter RenkeiDataTorikomiProcessParamter
     * @param 登録フラグ 登録フラグ
     * @return DbT5912ShujiiIryoKikanJohoEntity
     */
    public DbT5912ShujiiJohoEntity setDbt5912Entity(DbT5912RelateEntity entity,
            RenkeiDataTorikomiProcessParamter processParamter, boolean 登録フラグ) {
        DbT5912ShujiiJohoEntity dbt5912Entity;
        if (登録フラグ) {
            dbt5912Entity = new DbT5912ShujiiJohoEntity();
        } else {
            dbt5912Entity = entity.getDbT5912Entity();
        }
        DbT5912TempEntity dbT5912TempEntity = entity.getDbt5912TempEntity();
        dbt5912Entity.setShichosonCode(new LasdecCode(processParamter.get市町村コード()));
        dbt5912Entity.setShujiiIryokikanCode(dbT5912TempEntity.get医療機関コード());
        dbt5912Entity.setShujiiCode(dbT5912TempEntity.get主治医コード());
        dbt5912Entity.setShujiiName(dbT5912TempEntity.get主治医名称());
        if (!processParamter.is厚労省フラグ()) {
            dbt5912Entity.setShujiiKana(getKanaMeisho(dbT5912TempEntity.get主治医名称カナ()));
        }
        dbt5912Entity.setJokyoFlag(dbT5912TempEntity.is状況());
        return dbt5912Entity;
    }

    /**
     * DbT5912KoroshoErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5912ErrorTempEntity
     * @return DbT5912KoroshoErrorTempEUCEntity
     */
    public DbT5912KoroshoErrorTempEUCEntity setDbT5912KoroshoErrorTempEUCEntity(DbT5912ErrorTempEntity entity) {
        DbT5912KoroshoErrorTempEUCEntity eucEntity = new DbT5912KoroshoErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set医療機関コード(entity.get医療機関コード());
        eucEntity.set主治医コード(entity.get主治医コード());
        eucEntity.set主治医名称(entity.get主治医名称());
        eucEntity.set状況(entity.is状況());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5912ErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5912ErrorTempEntity
     * @return DbT5912ErrorTempEUCEntity
     */
    public DbT5912ErrorTempEUCEntity setDbT5912ErrorTempEUCEntity(DbT5912ErrorTempEntity entity) {
        DbT5912ErrorTempEUCEntity eucEntity = new DbT5912ErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set医療機関コード(entity.get医療機関コード());
        eucEntity.set主治医コード(entity.get主治医コード());
        eucEntity.set主治医名称(entity.get主治医名称());
        eucEntity.set状況(entity.is状況());
        eucEntity.set主治医名称カナ(entity.get主治医名称カナ());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5911ShujiiIryoKikanJohoEntityの設定メッソドです。
     *
     * @param entity DbT5911RelateEntity
     * @param processParamter RenkeiDataTorikomiProcessParamter
     * @param 登録フラグ 登録フラグ
     * @return DbT5911ShujiiIryoKikanJohoEntity
     */
    public DbT5911ShujiiIryoKikanJohoEntity setDbt5911Entity(DbT5911RelateEntity entity,
            RenkeiDataTorikomiProcessParamter processParamter, boolean 登録フラグ) {
        DbT5911ShujiiIryoKikanJohoEntity dbt5911Entity;
        if (登録フラグ) {
            dbt5911Entity = new DbT5911ShujiiIryoKikanJohoEntity();
        } else {
            dbt5911Entity = entity.getDbT5911Entity();
        }
        DbT5911TempEntity dbT5911TempEntity = entity.getDbt5911TempEntity();
        dbt5911Entity.setShichosonCode(new LasdecCode(processParamter.get市町村コード()));
        dbt5911Entity.setShujiiIryokikanCode(dbT5911TempEntity.get医療機関コード());
        dbt5911Entity.setIryoKikanMeisho(dbT5911TempEntity.get医療機関名称());
        if (!processParamter.is厚労省フラグ()) {
            dbt5911Entity.setIryoKikanMeishoKana(dbT5911TempEntity.get医療機関名称カナ());
        }
        dbt5911Entity.setYubinNo(getYubinNo(dbT5911TempEntity.get郵便番号()));
        dbt5911Entity.setJusho(dbT5911TempEntity.get住所());
        dbt5911Entity.setTelNo(getTelNo(dbT5911TempEntity.get電話番号()));
        dbt5911Entity.setJokyoFlag(dbT5911TempEntity.is状況());
        return dbt5911Entity;
    }

    /**
     * DbT5911KoroshoErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5911ErrorTempEntity
     * @return DbT5911KoroshoErrorTempEUCEntity
     */
    public DbT5911KoroshoErrorTempEUCEntity setDbT5911KoroshoErrorTempEUCEntity(DbT5911ErrorTempEntity entity) {
        DbT5911KoroshoErrorTempEUCEntity eucEntity = new DbT5911KoroshoErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set医療機関コード(entity.get医療機関コード());
        eucEntity.set医療機関名称(entity.get医療機関名称());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.set電話番号(entity.get電話番号());
        eucEntity.set状況(entity.is状況());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5911ErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5911ErrorTempEntity
     * @return DbT5911ErrorTempEUCEntity
     */
    public DbT5911ErrorTempEUCEntity setDbT5911ErrorTempEUCEntity(DbT5911ErrorTempEntity entity) {
        DbT5911ErrorTempEUCEntity eucEntity = new DbT5911ErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set医療機関コード(entity.get医療機関コード());
        eucEntity.set医療機関名称(entity.get医療機関名称());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.set電話番号(entity.get電話番号());
        eucEntity.set状況(entity.is状況());
        eucEntity.set医療機関名称カナ(entity.get医療機関名称カナ());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5913ChosainJohoEntityの設定メッソドです。
     *
     * @param entity DbT5913RelateEntity
     * @param processParamter RenkeiDataTorikomiProcessParamter
     * @param 登録フラグ 登録フラグ
     * @return DbT5913ChosainJohoEntity
     */
    public DbT5913ChosainJohoEntity setDbt5913Entity(DbT5913RelateEntity entity,
            RenkeiDataTorikomiProcessParamter processParamter, boolean 登録フラグ) {
        DbT5913ChosainJohoEntity dbt5913Entity;
        if (登録フラグ) {
            dbt5913Entity = new DbT5913ChosainJohoEntity();
            dbt5913Entity.setSeibetsu(new RString(""));
        } else {
            dbt5913Entity = entity.getDbT5913Entity();
        }
        DbT5913TempEntity dbT5913TempEntity = entity.getDbt5913TempEntity();
        dbt5913Entity.setShichosonCode(new LasdecCode(processParamter.get市町村コード()));
        dbt5913Entity.setNinteiChosaItakusakiCode(dbT5913TempEntity.get委託先コード());
        dbt5913Entity.setNinteiChosainCode(dbT5913TempEntity.get調査員コード());
        dbt5913Entity.setChosainShimei(dbT5913TempEntity.get調査員名称());
        if (!processParamter.is厚労省フラグ()) {
            dbt5913Entity.setChosainKanaShimei(dbT5913TempEntity.get調査員名称カナ());
        }
        dbt5913Entity.setChosainShikaku(dbT5913TempEntity.get資格コード());
        dbt5913Entity.setChosaKanoNinzuPerMonth(Integer.parseInt(
                DbBusinessConfig.get(ConfigNameDBE.調査員調査可能人数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
        dbt5913Entity.setJokyoFlag(dbT5913TempEntity.is状況());
        return dbt5913Entity;
    }

    /**
     * DbT5913KoroshoErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5913ErrorTempEntity
     * @return DbT5913KoroshoErrorTempEUCEntity
     */
    public DbT5913KoroshoErrorTempEUCEntity setDbT5913KoroshoErrorTempEUCEntity(DbT5913ErrorTempEntity entity) {
        DbT5913KoroshoErrorTempEUCEntity eucEntity = new DbT5913KoroshoErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set委託先コード(entity.get委託先コード());
        eucEntity.set調査員コード(entity.get調査員コード());
        eucEntity.set調査員名称(entity.get調査員名称());
        eucEntity.set資格コード(entity.get資格コード());
        eucEntity.set状況(entity.is状況());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5913ErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5913ErrorTempEntity
     * @return DbT5913ErrorTempEUCEntity
     */
    public DbT5913ErrorTempEUCEntity setDbT5913ErrorTempEUCEntity(DbT5913ErrorTempEntity entity) {
        DbT5913ErrorTempEUCEntity eucEntity = new DbT5913ErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set委託先コード(entity.get委託先コード());
        eucEntity.set調査員コード(entity.get調査員コード());
        eucEntity.set調査員名称(entity.get調査員名称());
        eucEntity.set資格コード(entity.get資格コード());
        eucEntity.set状況(entity.is状況());
        eucEntity.set調査員名称カナ(entity.get調査員名称カナ());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5910ErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5910ErrorTempEntity
     * @return DbT5910ErrorTempEUCEntity
     */
    public DbT5910KoroshoErrorTempEUCEntity setDbT5910KoroshoErrorTempEUCEntity(DbT5910ErrorTempEntity entity) {
        DbT5910KoroshoErrorTempEUCEntity eucEntity = new DbT5910KoroshoErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set委託先コード(entity.get委託先コード());
        eucEntity.set委託先名称(entity.get委託先名称());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.set電話番号(entity.get電話番号());
        eucEntity.set状況(entity.is状況());
        eucEntity.set委託区分コード(entity.get委託区分コード());
        eucEntity.set委託区分名称(entity.get委託区分名称());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5910ErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5910ErrorTempEntity
     * @return DbT5910ErrorTempEUCEntity
     */
    public DbT5910ErrorTempEUCEntity setDbT5910ErrorTempEUCEntity(DbT5910ErrorTempEntity entity) {
        DbT5910ErrorTempEUCEntity eucEntity = new DbT5910ErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set委託先コード(entity.get委託先コード());
        eucEntity.set委託先名称(entity.get委託先名称());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.set電話番号(entity.get電話番号());
        eucEntity.set状況(entity.is状況());
        eucEntity.set委託区分コード(entity.get委託区分コード());
        eucEntity.set委託区分名称(entity.get委託区分名称());
        eucEntity.set委託先名称カナ(entity.get委託先名称カナ());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5910NinteichosaItakusakiJohoEntityの設定メッソドです。
     *
     * @param entity DbT5910RelateEntity
     * @param processParamter RenkeiDataTorikomiProcessParamter
     * @param kubun 更新区分
     * @return DbT5910NinteichosaItakusakiJohoEntity
     */
    public DbT5910NinteichosaItakusakiJohoEntity setDbt5910Entity(DbT5910RelateEntity entity,
            RenkeiDataTorikomiProcessParamter processParamter, RString kubun) {
        DbT5910NinteichosaItakusakiJohoEntity dbt5910Entity;
        if (登録.equals(kubun)) {
            dbt5910Entity = new DbT5910NinteichosaItakusakiJohoEntity();
        } else {
            dbt5910Entity = entity.getDbT5910Entity();
        }
        DbT5910TempEntity dbT5910TempEntity = entity.getDbt5910TempEntity();
        dbt5910Entity.setShichosonCode(new LasdecCode(processParamter.get市町村コード()));
        dbt5910Entity.setNinteichosaItakusakiCode(dbT5910TempEntity.get委託先コード());
        dbt5910Entity.setJigyoshaMeisho(dbT5910TempEntity.get委託先名称());
        dbt5910Entity.setJigyoshaMeishoKana(dbT5910TempEntity.get委託先名称カナ());
        dbt5910Entity.setYubinNo(getYubinNo(dbT5910TempEntity.get郵便番号()));
        dbt5910Entity.setJusho(dbT5910TempEntity.get住所());
        dbt5910Entity.setTelNo(getTelNo(dbT5910TempEntity.get電話番号()));
        dbt5910Entity.setDaihyoshaName(dbT5910TempEntity.get委託先名称());
        if (!processParamter.is厚労省フラグ()) {
            dbt5910Entity.setDaihyoshaNameKana(dbT5910TempEntity.get委託先名称カナ());
        }
        dbt5910Entity.setChosaItakuKubun(dbT5910TempEntity.get委託区分コード());
        if (登録.equals(kubun)) {
            dbt5910Entity.setWaritsukeTeiin(Integer.parseInt(
                    DbBusinessConfig.get(ConfigNameDBE.認定調査委託先割付定員, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString()));
        }
        dbt5910Entity.setJokyoFlag(dbT5910TempEntity.is状況());
        return dbt5910Entity;
    }

    /**
     * DbT5101ErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5101ErrorTempEntity
     * @return DbT5101ErrorTempEUCEntity
     */
    public DbT5101ErrorTempEUCEntity setDbT5101ErrorTempEUCEntity(DbT5101ErrorTempEntity entity) {
        DbT5101ErrorTempEUCEntity eucEntity = new DbT5101ErrorTempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set認定申請日(entity.get認定申請日());
        eucEntity.set主キー補助項目(entity.get主キー補助項目());
        eucEntity.set申請種別コード(entity.get申請種別コード());
        eucEntity.set申請種別名称(entity.get申請種別名称());
        eucEntity.set取下区分コード(entity.get取下区分コード());
        eucEntity.set取下区分名称(TorisageKubunCode.toValue(entity.get取下区分コード()).get名称());
        eucEntity.set被保険者区分コード(entity.get被保険者区分コード());
        eucEntity.set被保険者区分名称(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        eucEntity.set申請代行区分コード(entity.get申請代行区分コード());
        eucEntity.set申請代行区分名称(ShinseiTodokedeDaikoKubunCode.toValue(entity.get申請代行区分コード()).get名称());
        eucEntity.set生年月日(entity.get生年月日());
        eucEntity.set年齢(entity.get年齢());
        eucEntity.set性別コード(entity.get性別());
        eucEntity.set性別(get性別(entity.get性別()));
        eucEntity.set氏名カナ(entity.get氏名カナ());
        eucEntity.set氏名(entity.get氏名());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5101KoroshoErrorTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5101TempEntity
     * @return DbT5101KoroshoErrorTempEUCEntity
     */
    public DbT5101KoroshoErrorTempEUCEntity setDbT5101KoroshoErrorTempEUCEntity(DbT5101ErrorTempEntity entity) {
        DbT5101KoroshoErrorTempEUCEntity eucEntity = new DbT5101KoroshoErrorTempEUCEntity();
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set認定申請日(entity.get認定申請日());
        eucEntity.set申請種別コード(entity.get申請種別コード());
        eucEntity.set申請種別名称(entity.get申請種別名称());
        eucEntity.set取下区分コード(entity.get取下区分コード());
        eucEntity.set取下区分名称(entity.get取下区分名称());
        eucEntity.set被保険者区分コード(entity.get被保険者区分コード());
        eucEntity.set被保険者区分名称(entity.get被保険者区分名称());
        eucEntity.set生年月日(entity.get生年月日());
        eucEntity.set性別コード(entity.get性別());
        eucEntity.set性別(get性別(entity.get性別()));
        eucEntity.set氏名カナ(entity.get氏名カナ());
        eucEntity.set氏名(entity.get氏名());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.setエラー内容(entity.getエラー内容());
        return eucEntity;
    }

    /**
     * DbT5101KoroshoTempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5101TempEntity
     * @return DbT5101KoroshoTempEUCEntity
     */
    public DbT5101KoroshoTempEUCEntity setDbT5101KoroshoTempEUCEntity(DbT5101TempEntity entity) {
        DbT5101KoroshoTempEUCEntity eucEntity = new DbT5101KoroshoTempEUCEntity();
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set認定申請日(entity.get認定申請日());
        eucEntity.set申請種別コード(entity.get申請区分_申請時コード());
        eucEntity.set申請種別名称(NinteiShinseiShinseijiKubunCode.toValue(entity.get申請区分_申請時コード()).get名称());
        eucEntity.set取下区分コード(entity.get取下区分コード());
        eucEntity.set取下区分名称(TorisageKubunCode.toValue(entity.get取下区分コード()).get名称());
        eucEntity.set被保険者区分コード(entity.get被保険者区分コード());
        eucEntity.set被保険者区分名称(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        eucEntity.set生年月日(entity.get生年月日());
        eucEntity.set性別コード(entity.get性別());
        eucEntity.set性別(get性別(entity.get性別()));
        eucEntity.set氏名カナ(entity.get氏名_カナ());
        eucEntity.set氏名(entity.get氏名());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        return eucEntity;
    }

    /**
     * DbT5101TempEUCEntityの設定メッソドです。
     *
     * @param entity DbT5101TempEntity
     * @return DbT5101TempEUCEntity
     */
    public DbT5101TempEUCEntity setDbT5101TempEUCEntity(DbT5101TempEntity entity) {
        DbT5101TempEUCEntity eucEntity = new DbT5101TempEUCEntity();
        eucEntity.setシーケンシャル番号(entity.getシーケンシャル番号());
        eucEntity.set機能コード(entity.get機能コード());
        eucEntity.set識別コード(entity.get識別コード());
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set認定申請日(entity.get認定申請日());
        eucEntity.set主キー補助項目(entity.get主キー補助項目());
        eucEntity.set申請種別コード(entity.get申請区分_申請時コード());
        eucEntity.set申請種別名称(NinteiShinseiShinseijiKubunCode.toValue(entity.get申請区分_申請時コード()).get名称());
        eucEntity.set取下区分コード(entity.get取下区分コード());
        eucEntity.set取下区分名称(TorisageKubunCode.toValue(entity.get取下区分コード()).get名称());
        eucEntity.set被保険者区分コード(entity.get被保険者区分コード());
        eucEntity.set被保険者区分名称(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        eucEntity.set申請代行区分コード(entity.get申請代行区分コード());
        eucEntity.set申請代行区分名称(ShinseiTodokedeDaikoKubunCode.toValue(entity.get申請代行区分コード()).get名称());
        eucEntity.set生年月日(entity.get生年月日());
        eucEntity.set年齢(entity.get年齢());
        eucEntity.set性別コード(entity.get性別());
        eucEntity.set性別(get性別(entity.get性別()));
        eucEntity.set氏名カナ(entity.get氏名_カナ());
        eucEntity.set氏名(entity.get氏名());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        return eucEntity;
    }

    /**
     * DbT5123NinteiKeikakuJohoEntityの設定メッソドです。
     *
     * @param entity DbT5101RelateEntity
     * @param kubun 更新区分
     * @return DbT5123NinteiKeikakuJohoEntity
     */
    public DbT5123NinteiKeikakuJohoEntity getDbT5123Entity(DbT5101RelateEntity entity, RString kubun) {
        if (登録.equals(kubun)) {
            return getDbT5123Entity_登録(entity);
        } else if (更新2.equals(kubun)) {
            return getDbT5123Entity_更新2(entity);
        } else {
            return getDbT5123Entity_更新1(entity);
        }
    }

    private DbT5123NinteiKeikakuJohoEntity getDbT5123Entity_登録(DbT5101RelateEntity entity) {
        DbT5123NinteiKeikakuJohoEntity dbt5123Entity = new DbT5123NinteiKeikakuJohoEntity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        RDate 基準日 = RDate.getNowDate();
        dbt5123Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        dbt5123Entity.setNinteichosaIraiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定調査依頼予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setNinteichosaYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定調査予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setIkenshoSakuseiIraiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setIkenshoTorokuYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.主治医意見書登録予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setIchijiHanteiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.要介護認定一次判定予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setNinteiShinsakaiWariateYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定審査会割当予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setNinteiShinsakaiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定審査会予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setCenterSoshinYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.センター送信予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        return dbt5123Entity;
    }

    private DbT5123NinteiKeikakuJohoEntity getDbT5123Entity_更新2(DbT5101RelateEntity entity) {
        DbT5123NinteiKeikakuJohoEntity dbt5123Entity = entity.getDbT5123Entity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        RDate 基準日 = RDate.getNowDate();
        dbt5123Entity.setNinteichosaIraiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定調査依頼予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setNinteichosaYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定調査予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setIkenshoSakuseiIraiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setIkenshoTorokuYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.主治医意見書登録予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setIchijiHanteiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.要介護認定一次判定予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setNinteiShinsakaiWariateYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定審査会割当予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setNinteiShinsakaiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.認定審査会予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        dbt5123Entity.setCenterSoshinYoteiYMD(setFlexibleDate(dbt5101tempEntity.get認定申請日(),
                DbBusinessConfig.get(ConfigNameDBE.センター送信予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        return dbt5123Entity;
    }

    private DbT5123NinteiKeikakuJohoEntity getDbT5123Entity_更新1(DbT5101RelateEntity entity) {
        DbT5123NinteiKeikakuJohoEntity dbt5123Entity = entity.getDbT5123Entity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        RDate 基準日 = RDate.getNowDate();
        if (dbt5101tempEntity.get前回の認定有効終了期間() == null || dbt5101tempEntity.get前回の認定有効終了期間().isEmpty()) {
            dbt5123Entity.setNinteichosaIraiYoteiYMD(null);
            dbt5123Entity.setNinteichosaYoteiYMD(null);
            dbt5123Entity.setIkenshoSakuseiIraiYoteiYMD(null);
            dbt5123Entity.setIkenshoTorokuYoteiYMD(null);
            dbt5123Entity.setIchijiHanteiYoteiYMD(null);
            dbt5123Entity.setNinteiShinsakaiWariateYoteiYMD(null);
            dbt5123Entity.setNinteiShinsakaiYoteiYMD(null);
            dbt5123Entity.setCenterSoshinYoteiYMD(null);
        } else {
            dbt5123Entity.setNinteichosaIraiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.認定調査依頼予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setNinteichosaYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.認定調査予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setIkenshoSakuseiIraiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setIkenshoTorokuYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.主治医意見書登録予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setIchijiHanteiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.要介護認定一次判定予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setNinteiShinsakaiWariateYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.認定審査会割当予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setNinteiShinsakaiYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.認定審査会予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
            dbt5123Entity.setCenterSoshinYoteiYMD(setFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間(),
                    DbBusinessConfig.get(ConfigNameDBE.センター送信予定年月日, 基準日, SubGyomuCode.DBE認定支援)));
        }
        return dbt5123Entity;
    }
    
    /**
     * DbT5105NinteiKanryoJohoEntityの設定メソッドです。
     * 
     * @param entity DbT5101RelateEntity
     * @return DbT5105NinteiKanryoJohoEntity
     */
    public DbT5105NinteiKanryoJohoEntity getDbT5105Entity(DbT5101RelateEntity entity) {
        DbT5105NinteiKanryoJohoEntity dbt5105Entity = new DbT5105NinteiKanryoJohoEntity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        FlexibleDate 申請日 = new FlexibleDate(dbt5101tempEntity.get認定申請日());
        dbt5105Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        dbt5105Entity.setNinteiShinseiJohoTorokuKanryoYMD(申請日);
        dbt5105Entity.setNinteichosaIraiKanryoYMD(申請日);
        dbt5105Entity.setNinteichosaKanryoYMD(申請日);
        dbt5105Entity.setIkenshoSakuseiIraiKanryoYMD(申請日);
        dbt5105Entity.setIkenshoTorokuKanryoYMD(申請日);
        dbt5105Entity.setIchijiHanteiKanryoYMD(申請日);
        dbt5105Entity.setMaskingKanryoYMD(申請日);
        dbt5105Entity.setNinteiShinsakaiWariateKanryoYMD(申請日);
        dbt5105Entity.setNinteiShinsakaiKanryoYMD(申請日);
        return dbt5105Entity;
    }
    
    /**
     * DbT5121ShinseiRirekiJohoEntityの設定メソッドです。
     * 
     * @param entity DbT5101RelateEntity
     * @return DbT5121ShinseiRirekiJohoEntity
     */
    public DbT5121ShinseiRirekiJohoEntity getDbT5121Entity(DbT5101RelateEntity entity) {
        DbT5121ShinseiRirekiJohoEntity dbt5121Entity = new DbT5121ShinseiRirekiJohoEntity();
        DbT5101NinteiShinseiJohoEntity dbt5101Entity = entity.getDbT5101Entity();
        dbt5121Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        if (dbt5101Entity != null && !dbt5101Entity.getShinseishoKanriNo().isEmpty()) {
            dbt5121Entity.setZenkaiShinseishoKanriNo(dbt5101Entity.getShinseishoKanriNo());
        } else {
            dbt5121Entity.setZenkaiShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号_ZERO17));
        }
        return dbt5121Entity;
    }
    
    /**
     * DbT5129TennyuShiboEntityの設定メソッドです。
     * 
     * @param entity DbT5101RelateEntity
     * @return DbT5129TennyuShiboEntity
     */
    public DbT5129TennyuShiboEntity getDbT5129Entity(DbT5101RelateEntity entity) {
        DbT5129TennyuShiboEntity dbt5129Entity = new DbT5129TennyuShiboEntity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        dbt5129Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        dbt5129Entity.setNijiHanteiYMD(new FlexibleDate(dbt5101tempEntity.get認定申請日()));
        dbt5129Entity.setNijiHanteiYokaigoJotaiKubunCode(new Code(dbt5101tempEntity.get前回の審査会結果()));
        FlexibleDate 前回認定有効開始期間 = new FlexibleDate(RString.EMPTY);
        FlexibleDate 前回認定有効終了期間 = new FlexibleDate(RString.EMPTY);
        if (dbt5101tempEntity.get前回の認定有効開始期間() != null && !dbt5101tempEntity.get前回の認定有効開始期間().isEmpty()) {
            前回認定有効開始期間 = new FlexibleDate(dbt5101tempEntity.get前回の認定有効開始期間());
        }
        if (dbt5101tempEntity.get前回の認定有効終了期間() != null && !dbt5101tempEntity.get前回の認定有効終了期間().isEmpty()) {
            前回認定有効終了期間 = new FlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間());
        }
        int 前回認定有効期間 = 0;
        if (前回認定有効開始期間.isEmpty() && 前回認定有効終了期間.isEmpty()) {
            前回認定有効期間 = 前回認定有効終了期間.getBetweenMonths(前回認定有効開始期間);
        }
        dbt5129Entity.setNijiHanteiNinteiYukoKikan(前回認定有効期間);
        dbt5129Entity.setNijiHanteiNinteiYukoKaishiYMD(前回認定有効開始期間);
        dbt5129Entity.setNijiHanteiNinteiYukoShuryoYMD(前回認定有効終了期間);
        dbt5129Entity.setShinsakaiKaisaiNo(new RString("0"));
        dbt5129Entity.setNijiHanteiKekkaInputHoho(new Code(NijiHanteiKekkaInputHoho.画面入力.getコード()));
        return dbt5129Entity;
    }
    
    /**
     * DbT5130ShiboEntityの設定メソッドです。
     * 
     * @param entity DbT5101RelateEntity
     * @return DbT5130ShiboEntity
     */
    public DbT5130ShiboEntity getDbT5130Entity(DbT5101RelateEntity entity) {
        DbT5130ShiboEntity dbt5130Entity = new DbT5130ShiboEntity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        dbt5130Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        dbt5130Entity.setNijiHanteiYMD(new FlexibleDate(dbt5101tempEntity.get認定申請日()));
        dbt5130Entity.setShinsakaiKaisaiNo(new RString("0"));
        dbt5130Entity.setNijiHanteiKekkaInputHoho(new Code(NijiHanteiKekkaInputHoho.画面入力.getコード()));
        return dbt5130Entity;
    }

    private FlexibleDate setFlexibleDate(RString value, RString config) {
        if (!RString.isNullOrEmpty(value)) {
            return new FlexibleDate(value).plusDay(Integer.parseInt(config.toString()));
        }
        return null;
    }

    /**
     * DbT5101NinteiShinseiJohoEntityの設定メッソドです。
     *
     * @param entity DbT5101RelateEntity
     * @param kubun 更新区分
     * @param processParamter RenkeiDataTorikomiProcessParamter
     * @return DbT5101TempEUCEntity
     */
    public DbT5101NinteiShinseiJohoEntity setDbt5101Entity(DbT5101RelateEntity entity, RString kubun,
            RenkeiDataTorikomiProcessParamter processParamter) {
        CountedItem countedItem = Saiban.get(
                SubGyomuCode.DBE認定支援, SaibanHanyokeyName.市町村コード_西暦_月.get名称(), FlexibleDate.getNowDate().getNendo());
        rstring申請書管理番号 = processParamter.get市町村コード().concat(
                FlexibleDate.getNowDate().getYearMonth().toString().concat(
                        countedItem.nextString().padZeroToLeft(採番番号桁数).toString()));
        if (processParamter.is厚労省フラグ()) {
            return getDbt5101Entity_厚労省(entity, kubun);
        } else {
            return getDbt5101Entity_電算(entity, kubun);
        }
    }

    private DbT5101NinteiShinseiJohoEntity getDbt5101Entity_厚労省(DbT5101RelateEntity entity, RString kubun) {
        DbT5101NinteiShinseiJohoEntity dbt5101Entity;
        if (登録.equals(kubun)) {
            dbt5101Entity = new DbT5101NinteiShinseiJohoEntity();
            dbt5101Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        } else {
            dbt5101Entity = entity.getDbT5101Entity();
        }
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        dbt5101Entity.setKoroshoIfShikibetsuCode(getCode(dbt5101tempEntity.get識別コード()));
        dbt5101Entity.setShoKisaiHokenshaNo(dbt5101tempEntity.get保険者番号());
        dbt5101Entity.setHihokenshaNo(dbt5101tempEntity.get被保険者番号());
        if (更新2.equals(kubun) || 登録.equals(kubun)) {
            dbt5101Entity.setShinseiNendo(getNendo(dbt5101tempEntity.get認定申請日()));
        }
        if (登録.equals(kubun)) {
            dbt5101Entity.setNinteiShinseiEdabanCode(new EdabanCode(CODE1));
            dbt5101Entity.setNinteiShinseiHoreiKubunCode(getCode(dbt5101tempEntity.get申請区分_法令コード()));
            dbt5101Entity.setNinteiShinseiYukoKubunCode(new Code(NinteiShinseiYukoKubunCode.有効.getコード()));
            dbt5101Entity.setChosaKubun(new Code(ChosaKubun.新規調査.getコード()));
            dbt5101Entity.setShoriJotaiKubun(new Code(CODE0));
            dbt5101Entity.setLogicalDeletedFlag(false);
            dbt5101Entity.setShishoCode(null);
            dbt5101Entity.setKoikinaiTenkyoKubun(null);
            dbt5101Entity.setShienShinseiKubun(null);
            dbt5101Entity.setJidoWariateJogaishaKubun(null);
            dbt5101Entity.setMinashiNigoEtcTaishoFlag(false);
            dbt5101Entity.setJohoteikyoDoiFlag(false);
        }
        dbt5101Entity.setNinteiShinseiYMD(getFlexibleDate(dbt5101tempEntity.get認定申請日()));
        dbt5101Entity.setNinteiShinseiShinseijiKubunCode(getCode(dbt5101tempEntity.get申請区分_申請時コード()));
        dbt5101Entity.setTorisageKubunCode(getCode(dbt5101tempEntity.get取下区分コード()));
        dbt5101Entity.setHihokenshaKubunCode(dbt5101tempEntity.get被保険者区分コード());
        dbt5101Entity.setSeinengappiYMD(getFlexibleDate(dbt5101tempEntity.get生年月日()));
        dbt5101Entity.setAge(getInt(dbt5101tempEntity.get年齢()));
        dbt5101Entity.setSeibetsu(getCode(dbt5101tempEntity.get性別()));
        dbt5101Entity.setHihokenshaKana(getKanaMeisho(dbt5101tempEntity.get氏名_カナ()));
        dbt5101Entity.setHihokenshaName(getMeisho(dbt5101tempEntity.get氏名()));
        dbt5101Entity.setYubinNo(getYubinNo(dbt5101tempEntity.get郵便番号()));
        dbt5101Entity.setJusho(getAtenaJusho(dbt5101tempEntity.get住所()));
        dbt5101Entity.setTelNo(getTelNo(dbt5101tempEntity.get本人連絡先1()));
        dbt5101Entity.setZenYokaigoKubunCode(getCode(dbt5101tempEntity.get前回の審査会結果()));
        dbt5101Entity.setZenkaiNinteiYMD(getFlexibleDate(dbt5101tempEntity.get二次判定日()));
        dbt5101Entity.setZenkaiYukoKikanStart(getFlexibleDate(dbt5101tempEntity.get前回の認定有効開始期間()));
        dbt5101Entity.setZenkaiYukoKikanEnd(getFlexibleDate(dbt5101tempEntity.get前回の認定有効終了期間()));
        dbt5101Entity.setShujiiIryokikanCode(getShujiiIryokikanCode(dbt5101tempEntity.get主治医医療機関コード()));
        dbt5101Entity.setShujiiCode(getShujiiCode(dbt5101tempEntity.get主治医番号()));
        return dbt5101Entity;
    }

    private DbT5101NinteiShinseiJohoEntity getDbt5101Entity_電算(DbT5101RelateEntity entity, RString kubun) {
        DbT5101NinteiShinseiJohoEntity dbt5101Entity;
        if (登録.equals(kubun)) {
            dbt5101Entity = new DbT5101NinteiShinseiJohoEntity();
            dbt5101Entity.setShinseishoKanriNo(new ShinseishoKanriNo(rstring申請書管理番号));
        } else {
            dbt5101Entity = entity.getDbT5101Entity();
        }
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        dbt5101Entity.setKoroshoIfShikibetsuCode(getCode(dbt5101tempEntity.get識別コード()));
        dbt5101Entity.setShoKisaiHokenshaNo(dbt5101tempEntity.get保険者番号());
        dbt5101Entity.setHihokenshaNo(dbt5101tempEntity.get被保険者番号());
        if (更新2.equals(kubun) || 登録.equals(kubun)) {
            dbt5101Entity.setShinseiNendo(getNendo(dbt5101tempEntity.get認定申請日()));
        }
        if (登録.equals(kubun)) {
            dbt5101Entity.setNinteiShinseiEdabanCode(new EdabanCode(CODE1));
            dbt5101Entity.setNinteiShinseiHoreiKubunCode(getCode(dbt5101tempEntity.get申請区分_法令コード()));
            dbt5101Entity.setNinteiShinseiYukoKubunCode(new Code(NinteiShinseiYukoKubunCode.有効.getコード()));
            dbt5101Entity.setChosaKubun(new Code(ChosaKubun.新規調査.getコード()));
            dbt5101Entity.setNyushoShisetsuCode(getJigyoshaNo(dbt5101tempEntity.get入所事業所コード()));
            dbt5101Entity.setShoriJotaiKubun(new Code(CODE0));
            dbt5101Entity.setLogicalDeletedFlag(false);
            dbt5101Entity.setShishoCode(null);
            dbt5101Entity.setKoikinaiTenkyoKubun(null);
            dbt5101Entity.setShienShinseiKubun(null);
            dbt5101Entity.setJidoWariateJogaishaKubun(null);
            dbt5101Entity.setMinashiNigoEtcTaishoFlag(false);
            dbt5101Entity.setJohoteikyoDoiFlag(false);
        }
        dbt5101Entity.setNinteiShinseiYMD(getFlexibleDate(dbt5101tempEntity.get認定申請日()));
        dbt5101Entity.setNinteiShinseiShinseijiKubunCode(getCode(dbt5101tempEntity.get申請区分_申請時コード()));
        dbt5101Entity.setTorisageKubunCode(getCode(dbt5101tempEntity.get取下区分コード()));
        dbt5101Entity.setHihokenshaKubunCode(dbt5101tempEntity.get被保険者区分コード());
        dbt5101Entity.setSeinengappiYMD(getFlexibleDate(dbt5101tempEntity.get生年月日()));
        dbt5101Entity.setAge(getInt(dbt5101tempEntity.get年齢()));
        dbt5101Entity.setSeibetsu(getCode(dbt5101tempEntity.get性別()));
        dbt5101Entity.setHihokenshaKana(getKanaMeisho(dbt5101tempEntity.get氏名_カナ()));
        dbt5101Entity.setHihokenshaName(getMeisho(dbt5101tempEntity.get氏名()));
        dbt5101Entity.setYubinNo(getYubinNo(dbt5101tempEntity.get郵便番号()));
        dbt5101Entity.setJusho(getAtenaJusho(dbt5101tempEntity.get住所()));
        dbt5101Entity.setTelNo(getTelNo(dbt5101tempEntity.get本人連絡先1()));
        dbt5101Entity.setNigoTokuteiShippeiCode(getCode(dbt5101tempEntity.get特定疾病コード()));
        dbt5101Entity.setNinteiChosaItakusakiCode(getChosaItakusakiCode(dbt5101tempEntity.get調査委託先コード()));
        dbt5101Entity.setShujiiIryokikanCode(getShujiiIryokikanCode(dbt5101tempEntity.get主治医医療機関コード()));
        dbt5101Entity.setShujiiCode(getShujiiCode(dbt5101tempEntity.get主治医番号()));
        if (!RString.isNullOrEmpty(dbt5101tempEntity.get入所事業所コード())) {
            dbt5101Entity.setShisetsuNyushoFlag(true);
        }
        return dbt5101Entity;
    }

    private ShujiiCode getShujiiCode(RString value) {
        ShujiiCode 主治医番号 = ShujiiCode.EMPTY;
        if (RString.isNullOrEmpty(value)) {
            主治医番号 = new ShujiiCode(value);
        }
        return 主治医番号;
    }

    private ShujiiIryokikanCode getShujiiIryokikanCode(RString value) {
        ShujiiIryokikanCode 主治医医療機関コード = ShujiiIryokikanCode.EMPTY;
        if (RString.isNullOrEmpty(value)) {
            主治医医療機関コード = new ShujiiIryokikanCode(value);
        }
        return 主治医医療機関コード;
    }

    private RString get性別(RString value) {
        RString 性別 = RString.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            性別 = Seibetsu.toValue(value).get名称();
        }
        return 性別;
    }

    private JigyoshaNo getJigyoshaNo(RString value) {
        JigyoshaNo jigyoshaNo = JigyoshaNo.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            jigyoshaNo = new JigyoshaNo(value);
        }
        return jigyoshaNo;
    }

    private FlexibleYear getNendo(RString value) {
        FlexibleYear 年度 = FlexibleYear.EMPTY;
        if (getFlexibleDate(value) != null) {
            年度 = getFlexibleDate(value).getNendo();
        }
        return 年度;
    }

    private ChosaItakusakiCode getChosaItakusakiCode(RString value) {
        ChosaItakusakiCode 戻り値 = ChosaItakusakiCode.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new ChosaItakusakiCode(value);
        }
        return 戻り値;
    }

    private TelNo getTelNo(RString value) {
        TelNo 戻り値 = TelNo.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new TelNo(value);
        }
        return 戻り値;
    }

    private AtenaJusho getAtenaJusho(RString value) {
        AtenaJusho 戻り値 = AtenaJusho.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new AtenaJusho(value);
        }
        return 戻り値;
    }

    private YubinNo getYubinNo(RString value) {
        YubinNo 戻り値 = YubinNo.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new YubinNo(value);
        }
        return 戻り値;
    }

    private AtenaMeisho getMeisho(RString value) {
        AtenaMeisho 戻り値 = AtenaMeisho.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new AtenaMeisho(value);
        }
        return 戻り値;
    }

    private AtenaKanaMeisho getKanaMeisho(RString value) {
        AtenaKanaMeisho 戻り値 = AtenaKanaMeisho.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new AtenaKanaMeisho(value);
        }
        return 戻り値;
    }

    private int getInt(RString value) {
        int 戻り値 = 0;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = Integer.parseInt(value.toString());
        }
        return 戻り値;
    }

    private FlexibleDate getFlexibleDate(RString value) {
        FlexibleDate flexibleDate = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            flexibleDate = new FlexibleDate(value);
        }
        return flexibleDate;
    }

    private Code getCode(RString value) {
        Code 戻り値 = Code.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = new Code(value);
        }
        return 戻り値;
    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(RenkeiDataTorikomiProcessParamter processParamter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("市町村コード"));
        jokenBuilder.append(processParamter.get市町村コード());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void getアクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.更新, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
