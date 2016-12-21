/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.rirekishusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.rirekishusei.RirekiShuseiRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4201NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4202NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4301ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4302ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.rirekishusei.RirekiShuseiDataPass;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 特殊修正Businessクラスです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
public class RirekiShuseiBusiness implements Serializable {

    private static final long serialVersionUID = -2991383053468849136L;
    private final JukyushaDaicho dbt4001;
    private final DbT4101NinteiShinseiJoho dbt4101;
    private final DbT4121ShinseiRirekiJoho dbt4121;
    private final DbT4102NinteiKekkaJoho dbt4102;
    private final DbT4120ShinseitodokedeJoho dbt4120;
    private final IchijiHanteiKekkaJoho dbt4116;
    private final DbT4123NinteiKeikakuJoho dbt4123;
    private final DbT4301ShujiiIkenshoIraiJoho dbt4301;
    private final DbT4302ShujiiIkenshoJoho dbt4302;
    private final DbT4201NinteichosaIraiJoho dbt4201;
    private final DbT4202NinteichosahyoGaikyoChosa dbt4202;
    private final DbT4910NinteichosaItakusakiJohoEntity dbt4910Entity;
    private final DbT4911ShujiiIryoKikanJohoEntity dbt4911Entity;
    private final DbT4912ShujiiJohoEntity dbt4912Entity;
    private final DbT4913ChosainJohoEntity dbt4913Entity;
    private final int updateCount;

    /**
     * コンストラクタです。
     *
     * @param entity 特殊修正のEntity
     */
    public RirekiShuseiBusiness(RirekiShuseiRelateEntity entity) {
        if (entity.getDbt4001Entity() != null) {
            entity.getDbt4001Entity().initializeMd5();
            dbt4001 = new JukyushaDaicho(entity.getDbt4001Entity());
        } else {
            dbt4001 = null;
        }
        if (entity.getDbt4101Entity() != null) {
            entity.getDbt4101Entity().initializeMd5();
            dbt4101 = new DbT4101NinteiShinseiJoho(entity.getDbt4101Entity());
        } else {
            dbt4101 = null;
        }
        if (entity.getDbt4102Entity() != null) {
            entity.getDbt4102Entity().initializeMd5();
            dbt4102 = new DbT4102NinteiKekkaJoho(entity.getDbt4102Entity());
        } else {
            dbt4102 = null;
        }
        if (entity.getDbt4116Entity() != null) {
            entity.getDbt4116Entity().initializeMd5();
            dbt4116 = new IchijiHanteiKekkaJoho(entity.getDbt4116Entity());
        } else {
            dbt4116 = null;
        }
        if (entity.getDbt4120Entity() != null) {
            entity.getDbt4120Entity().initializeMd5();
            dbt4120 = new DbT4120ShinseitodokedeJoho(entity.getDbt4120Entity());
        } else {
            dbt4120 = null;
        }
        if (entity.getDbt4121Entity() != null) {
            entity.getDbt4121Entity().initializeMd5();
            dbt4121 = new DbT4121ShinseiRirekiJoho(entity.getDbt4121Entity());
        } else {
            dbt4121 = null;
        }
        if (entity.getDbt4123Entity() != null) {
            entity.getDbt4123Entity().initializeMd5();
            dbt4123 = new DbT4123NinteiKeikakuJoho(entity.getDbt4123Entity());
        } else {
            dbt4123 = null;
        }
        if (entity.getDbt4201Entity() != null) {
            entity.getDbt4201Entity().initializeMd5();
            dbt4201 = new DbT4201NinteichosaIraiJoho(entity.getDbt4201Entity());
        } else {
            dbt4201 = null;
        }
        if (entity.getDbt4202Entity() != null) {
            entity.getDbt4202Entity().initializeMd5();
            dbt4202 = new DbT4202NinteichosahyoGaikyoChosa(entity.getDbt4202Entity());
        } else {
            dbt4202 = null;
        }
        if (entity.getDbt4301Entity() != null) {
            entity.getDbt4301Entity().initializeMd5();
            dbt4301 = new DbT4301ShujiiIkenshoIraiJoho(entity.getDbt4301Entity());
        } else {
            dbt4301 = null;
        }
        if (entity.getDbt4302Entity() != null) {
            entity.getDbt4302Entity().initializeMd5();
            dbt4302 = new DbT4302ShujiiIkenshoJoho(entity.getDbt4302Entity());
        } else {
            dbt4302 = null;
        }
        dbt4910Entity = entity.getDbt4910Entity();
        dbt4911Entity = entity.getDbt4911Entity();
        dbt4912Entity = entity.getDbt4912Entity();
        dbt4913Entity = entity.getDbt4913Entity();
        updateCount = entity.getUpdateCount();
    }

    /**
     * 受給者台帳を取得します
     *
     * @return 受給者台帳
     */
    public JukyushaDaicho get受給者台帳() {
        return dbt4001;
    }

    /**
     * 要介護認定申請情報を取得します
     *
     * @return 要介護認定申請情報
     */
    public DbT4101NinteiShinseiJoho get要介護認定申請情報() {
        return dbt4101;
    }

    /**
     * 要介護認定結果情報を取得します
     *
     * @return 要介護認定結果情報
     */
    public DbT4102NinteiKekkaJoho get要介護認定結果情報() {
        return dbt4102;
    }

    /**
     * 一次判定結果を取得します
     *
     * @return 一次判定結果
     */
    public IchijiHanteiKekkaJoho get一次判定結果() {
        return dbt4116;
    }

    /**
     * 申請届出情報を取得します
     *
     * @return 申請届出情報
     */
    public DbT4120ShinseitodokedeJoho get申請届出情報() {
        return dbt4120;
    }

    /**
     * 申請履歴情報を取得します
     *
     * @return 申請履歴情報
     */
    public DbT4121ShinseiRirekiJoho get申請履歴情報() {
        return dbt4121;
    }

    /**
     * 要介護認定計画情報を取得します
     *
     * @return 要介護認定計画情報
     */
    public DbT4123NinteiKeikakuJoho get要介護認定計画情報() {
        return dbt4123;
    }

    /**
     * 認定調査依頼情報を取得します
     *
     * @return 認定調査依頼情報
     */
    public DbT4201NinteichosaIraiJoho get認定調査依頼情報() {
        return dbt4201;
    }

    /**
     * 主治医意見書作成依頼情報を取得します
     *
     * @return 主治医意見書作成依頼情報
     */
    public DbT4301ShujiiIkenshoIraiJoho get主治医意見書作成依頼情報() {
        return dbt4301;
    }

    /**
     * 要介護認定主治医意見書情報を取得します
     *
     * @return 要介護認定主治医意見書情報
     */
    public DbT4302ShujiiIkenshoJoho get要介護認定主治医意見書情報() {
        return dbt4302;
    }

    /**
     * 認定調査票（概況調査）を取得します
     *
     * @return 認定調査票_概況調査
     */
    public DbT4202NinteichosahyoGaikyoChosa get認定調査票_概況調査() {
        return dbt4202;
    }

    /**
     * 更新回数を取得します
     *
     * @return 更新回数
     */
    public int getUpdateCount() {
        return updateCount;
    }

    /**
     * DBZ.RirekiShuseiのデータを取得します
     *
     * @return 履歴修正情報
     */
    public RirekiShuseiDataPass get履歴修正情報() {
        RirekiShuseiDataPass dataPass = new RirekiShuseiDataPass();
        if (dbt4001 != null) {
            dataPass.setデータ区分(dbt4001.getデータ区分());
            dataPass.set認定年月日(new RDate(dbt4001.get認定年月日().getYearValue(),
                    dbt4001.get認定年月日().getMonthValue(), dbt4001.get認定年月日().getDayValue()));
            dataPass.set要介護状態区分コード(dbt4001.get要介護認定状態区分コード());
            dataPass.set認定有効開始年月日(new RDate(dbt4001.get認定有効期間開始年月日().getYearValue(),
                    dbt4001.get認定有効期間開始年月日().getMonthValue(), dbt4001.get認定有効期間開始年月日().getDayValue()));
            dataPass.set認定有効終了年月日(new RDate(dbt4001.get認定有効期間終了年月日().getYearValue(),
                    dbt4001.get認定有効期間終了年月日().getMonthValue(), dbt4001.get認定有効期間終了年月日().getDayValue()));
            dataPass.set旧措置フラグ(dbt4001.is旧措置者フラグ());
            dataPass.set受給申請事由(dbt4001.get受給申請事由());
            dataPass.set申請状況区分(dbt4001.get申請状況区分());
            dataPass.set資格取得前申請フラグ(dbt4001.is資格取得前申請フラグ());
            dataPass.setみなし要介護区分コード(dbt4001.getみなし要介護区分コード());
            dataPass.set指定サービス種類01(dbt4001.get指定サービス種類01());
            dataPass.set指定サービス種類02(dbt4001.get指定サービス種類02());
            dataPass.set指定サービス種類03(dbt4001.get指定サービス種類03());
            dataPass.set指定サービス種類04(dbt4001.get指定サービス種類04());
            dataPass.set指定サービス種類05(dbt4001.get指定サービス種類05());
            dataPass.set指定サービス種類06(dbt4001.get指定サービス種類06());
            dataPass.set指定サービス種類07(dbt4001.get指定サービス種類07());
            dataPass.set指定サービス種類08(dbt4001.get指定サービス種類08());
            dataPass.set指定サービス種類09(dbt4001.get指定サービス種類09());
            dataPass.set指定サービス種類10(dbt4001.get指定サービス種類10());
            dataPass.set指定サービス種類11(dbt4001.get指定サービス種類11());
            dataPass.set指定サービス種類12(dbt4001.get指定サービス種類12());
            dataPass.set指定サービス種類13(dbt4001.get指定サービス種類13());
            dataPass.set指定サービス種類14(dbt4001.get指定サービス種類14());
            dataPass.set指定サービス種類15(dbt4001.get指定サービス種類15());
            dataPass.set指定サービス種類16(dbt4001.get指定サービス種類16());
            dataPass.set指定サービス種類17(dbt4001.get指定サービス種類17());
            dataPass.set指定サービス種類18(dbt4001.get指定サービス種類18());
            dataPass.set指定サービス種類19(dbt4001.get指定サービス種類19());
            dataPass.set指定サービス種類20(dbt4001.get指定サービス種類20());
            dataPass.set指定サービス種類21(dbt4001.get指定サービス種類21());
            dataPass.set指定サービス種類22(dbt4001.get指定サービス種類22());
            dataPass.set指定サービス種類23(dbt4001.get指定サービス種類23());
            dataPass.set指定サービス種類24(dbt4001.get指定サービス種類24());
            dataPass.set指定サービス種類25(dbt4001.get指定サービス種類25());
            dataPass.set指定サービス種類26(dbt4001.get指定サービス種類26());
            dataPass.set指定サービス種類27(dbt4001.get指定サービス種類27());
            dataPass.set指定サービス種類28(dbt4001.get指定サービス種類28());
            dataPass.set指定サービス種類29(dbt4001.get指定サービス種類29());
            dataPass.set指定サービス種類30(dbt4001.get指定サービス種類30());
            dataPass.set削除事由コード(dbt4001.get削除事由コード());
            dataPass.set異動理由(dbt4001.get異動理由());
            dataPass.set喪失年月日(dbt4001.get喪失年月日());
            dataPass.set当初認定有効開始年月日(dbt4001.get当初認定有効開始年月日());
            dataPass.set当初認定有効終了年月日(dbt4001.get当初認定有効終了年月日());
            dataPass.set受給資格証明書発行年月日１(dbt4001.get受給資格証明書発行年月日１());
            dataPass.set受給資格証明書発行年月日２(dbt4001.get受給資格証明書発行年月日２());
            dataPass.set市町村コード(dbt4001.get市町村コード());
            dataPass.set申請書管理番号(dbt4001.get申請書管理番号());
        }
        if (dbt4102 != null) {
            dataPass.set介護認定審査会意見(dbt4102.get介護認定審査会意見());
            dataPass.set介護認定審査会資料作成年月日(new RDate(dbt4102.get介護認定審査会資料作成年月日().getYearValue(),
                    dbt4102.get介護認定審査会資料作成年月日().getMonthValue(), dbt4102.get介護認定審査会資料作成年月日().getDayValue()));
            dataPass.set二次判定年月日(new RDate(dbt4102.get二次判定年月日().getYearValue(),
                    dbt4102.get二次判定年月日().getMonthValue(), dbt4102.get二次判定年月日().getDayValue()));
            dataPass.set二次判定要介護状態区分コード(dbt4102.get二次判定要介護状態区分コード());
            dataPass.set二次判定認定有効期間(dbt4102.get二次判定認定有効期間());
            dataPass.set二次判定認定有効開始年月日(dbt4102.get二次判定認定有効開始年月日());
            dataPass.set二次判定認定有効終了年月日(dbt4102.get二次判定認定有効終了年月日());
        }
        if (dbt4101 != null) {
            dataPass.set要介護申請_要支援申請の区分(dbt4101.get要介護申請_要支援申請の区分());
            dataPass.set認定申請年月日(dbt4101.get認定申請年月日());
            dataPass.set認定申請区分_法令_コード(dbt4101.get認定申請区分_法令_コード());
            dataPass.set認定申請区分_申請時_コード(dbt4101.get認定申請区分_申請時_コード());
            dataPass.set被保険者区分コード(dbt4101.get被保険者区分コード());
            dataPass.set二号特定疾病コード(dbt4101.get２号特定疾病コード());
            dataPass.set支所コード(dbt4101.get支所コード());
            dataPass.set認定申請理由(dbt4101.get認定申請理由());
            dataPass.set取下年月日(dbt4101.get取下年月日());
            dataPass.set指定医フラグ(dbt4101.is指定医フラグ());
            dataPass.set訪問調査先名称(dbt4101.get訪問調査先名称());
            dataPass.set訪問調査先郵便番号(dbt4101.get訪問調査先郵便番号());
            dataPass.set訪問調査先住所(dbt4101.get訪問調査先住所());
            dataPass.set訪問調査先電話番号(dbt4101.get訪問調査先電話番号());
            dataPass.set延期通知発行年月日(new RDate(dbt4101.get延期通知発行年月日().getYearValue(),
                    dbt4101.get延期通知発行年月日().getMonthValue(), dbt4101.get延期通知発行年月日().getDayValue()));
            dataPass.set延期通知発行回数(dbt4101.get延期通知発行回数());
            dataPass.set厚労省IF識別コード(dbt4101.get厚労省IF識別コード());
        }
        if (dbt4120 != null) {
            dataPass.set届出代行区分(dbt4120.get申請届出代行区分コード());
            dataPass.set氏名(dbt4120.get申請届出者氏名());
            dataPass.setカナ氏名(dbt4120.get申請届出者氏名カナ());
            dataPass.set本人との関係性(dbt4120.get申請届出者続柄());
            dataPass.set事業者番号(dbt4120.get申請届出代行事業者番号());
            dataPass.set事業者区分(dbt4120.get事業者区分());
            dataPass.set郵便番号(dbt4120.get申請届出者郵便番号());
            dataPass.set住所(dbt4120.get申請届出者住所());
            dataPass.set電話番号(dbt4120.get申請届出者電話番号());
        }
        if (dbt4913Entity != null) {
            dataPass.set認定調査員コード(dbt4913Entity.getNinteiChosainCode());
            dataPass.set調査員氏名(dbt4913Entity.getChosainShimei());
        }
        if (dbt4910Entity != null) {
            dataPass.set認定調査委託先コード(dbt4910Entity.getNinteichosaItakusakiCode().value());
            dataPass.set事業者名称(dbt4910Entity.getJigyoshaMeisho());
            dataPass.set認定郵便番号(dbt4910Entity.getYubinNo());
            dataPass.set認定住所(dbt4910Entity.getJusho());
            dataPass.set認定電話番号(dbt4910Entity.getTelNo());
            dataPass.set調査委託区分(dbt4910Entity.getChosaItakuKubun());
        }
        if (dbt4201 != null) {
            dataPass.set認定調査依頼年月日(new RDate(dbt4201.get認定調査依頼年月日().getYearValue(),
                    dbt4201.get認定調査依頼年月日().getMonthValue(), dbt4201.get認定調査依頼年月日().getDayValue()));
        }
        if (dbt4123 != null) {
            dataPass.set認定調査予定年月日(new RDate(dbt4123.get認定調査予定年月日().getYearValue(),
                    dbt4123.get認定調査予定年月日().getMonthValue(), dbt4123.get認定調査予定年月日().getDayValue()));
            dataPass.set主治医意見書登録予定年月日(new RDate(dbt4123.get主治医意見書登録予定年月日().getYearValue(),
                    dbt4123.get主治医意見書登録予定年月日().getMonthValue(), dbt4123.get主治医意見書登録予定年月日().getDayValue()));
            dataPass.set認定審査会予定年月日(new RDate(dbt4123.get認定審査会予定年月日().getYearValue(),
                    dbt4123.get認定審査会予定年月日().getMonthValue(), dbt4123.get認定審査会予定年月日().getDayValue()));
        }
        if (dbt4202 != null) {
            dataPass.set認定調査実施年月日(new RDate(dbt4202.get認定調査実施年月日().getYearValue(),
                    dbt4202.get認定調査実施年月日().getMonthValue(), dbt4202.get認定調査実施年月日().getDayValue()));
        }
        if (dbt4912Entity != null) {
            dataPass.set主治医コード(dbt4912Entity.getShujiiCode());
            dataPass.set主治医氏名(dbt4912Entity.getShujiiName());
        }
        if (dbt4911Entity != null) {
            dataPass.set主治医医療機関コード(dbt4911Entity.getShujiiIryokikanCode().getColumnValue());
            dataPass.set医療機関名称(dbt4911Entity.getIryoKikanMeisho());
            dataPass.set主治医郵便番号(dbt4911Entity.getYubinNo());
            dataPass.set主治医住所(dbt4911Entity.getJusho());
            dataPass.set主治医電話番号(dbt4911Entity.getTelNo());
        }
        if (dbt4301 != null) {
            dataPass.set主治医意見書作成依頼年月日(new RDate(dbt4301.get主治医意見書作成依頼年月日().getYearValue(),
                    dbt4301.get主治医意見書作成依頼年月日().getMonthValue(), dbt4301.get主治医意見書作成依頼年月日().getDayValue()));
        }
        if (dbt4302 != null) {
            dataPass.set主治医意見書記入年月日(new RDate(dbt4302.get主治医意見書記入年月日().getYearValue(),
                    dbt4302.get主治医意見書記入年月日().getMonthValue(), dbt4302.get主治医意見書記入年月日().getDayValue()));
        }
        if (dbt4116 != null) {
            dataPass.set要介護認定一次判定結果コード(dbt4116.get要介護認定一次判定結果コード());
            dataPass.set要介護認定一次判定年月日(new RDate(dbt4116.get要介護認定一次判定年月日().getYearValue(),
                    dbt4116.get要介護認定一次判定年月日().getMonthValue(), dbt4116.get要介護認定一次判定年月日().getDayValue()));
            dataPass.set要介護認定一次判定結果コード_認知症加算(dbt4116.get要介護認定一次判定結果コード_認知症加算());
        }
        return dataPass;
    }

    /**
     * DBZ.RirekiShuseiのデータを取得します
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 履歴修正情報
     */
    public RirekiShuseiDataPass get履歴修正情報(Code 厚労省IF識別コード) {
        RirekiShuseiDataPass dataPass = new RirekiShuseiDataPass();
        if (dbt4001 != null) {
            dataPass.setデータ区分(Code.EMPTY);
            dataPass.set認定年月日(new RDate(dbt4001.get認定年月日().getYearValue(),
                    dbt4001.get認定年月日().getMonthValue(), dbt4001.get認定年月日().getDayValue()));
            dataPass.set要介護状態区分コード(Code.EMPTY);
            dataPass.set認定有効開始年月日(new RDate(dbt4001.get認定有効期間開始年月日().getYearValue(),
                    dbt4001.get認定有効期間開始年月日().getMonthValue(), dbt4001.get認定有効期間開始年月日().getDayValue()));
            dataPass.set認定有効終了年月日(new RDate(dbt4001.get認定有効期間終了年月日().getYearValue(),
                    dbt4001.get認定有効期間終了年月日().getMonthValue(), dbt4001.get認定有効期間終了年月日().getDayValue()));
            dataPass.set旧措置フラグ(dbt4001.is旧措置者フラグ());
            dataPass.set受給申請事由(dbt4001.get受給申請事由());
            dataPass.set申請状況区分(dbt4001.get申請状況区分());
            dataPass.set資格取得前申請フラグ(dbt4001.is資格取得前申請フラグ());
            dataPass.setみなし要介護区分コード(dbt4001.getみなし要介護区分コード());
            dataPass.set指定サービス種類01(dbt4001.get指定サービス種類01());
            dataPass.set指定サービス種類02(dbt4001.get指定サービス種類02());
            dataPass.set指定サービス種類03(dbt4001.get指定サービス種類03());
            dataPass.set指定サービス種類04(dbt4001.get指定サービス種類04());
            dataPass.set指定サービス種類05(dbt4001.get指定サービス種類05());
            dataPass.set指定サービス種類06(dbt4001.get指定サービス種類06());
            dataPass.set指定サービス種類07(dbt4001.get指定サービス種類07());
            dataPass.set指定サービス種類08(dbt4001.get指定サービス種類08());
            dataPass.set指定サービス種類09(dbt4001.get指定サービス種類09());
            dataPass.set指定サービス種類10(dbt4001.get指定サービス種類10());
            dataPass.set指定サービス種類11(dbt4001.get指定サービス種類11());
            dataPass.set指定サービス種類12(dbt4001.get指定サービス種類12());
            dataPass.set指定サービス種類13(dbt4001.get指定サービス種類13());
            dataPass.set指定サービス種類14(dbt4001.get指定サービス種類14());
            dataPass.set指定サービス種類15(dbt4001.get指定サービス種類15());
            dataPass.set指定サービス種類16(dbt4001.get指定サービス種類16());
            dataPass.set指定サービス種類17(dbt4001.get指定サービス種類17());
            dataPass.set指定サービス種類18(dbt4001.get指定サービス種類18());
            dataPass.set指定サービス種類19(dbt4001.get指定サービス種類19());
            dataPass.set指定サービス種類20(dbt4001.get指定サービス種類20());
            dataPass.set指定サービス種類21(dbt4001.get指定サービス種類21());
            dataPass.set指定サービス種類22(dbt4001.get指定サービス種類22());
            dataPass.set指定サービス種類23(dbt4001.get指定サービス種類23());
            dataPass.set指定サービス種類24(dbt4001.get指定サービス種類24());
            dataPass.set指定サービス種類25(dbt4001.get指定サービス種類25());
            dataPass.set指定サービス種類26(dbt4001.get指定サービス種類26());
            dataPass.set指定サービス種類27(dbt4001.get指定サービス種類27());
            dataPass.set指定サービス種類28(dbt4001.get指定サービス種類28());
            dataPass.set指定サービス種類29(dbt4001.get指定サービス種類29());
            dataPass.set指定サービス種類30(dbt4001.get指定サービス種類30());
            dataPass.set削除事由コード(dbt4001.get削除事由コード());
            dataPass.set異動理由(dbt4001.get異動理由());
            dataPass.set喪失年月日(dbt4001.get喪失年月日());
            dataPass.set当初認定有効開始年月日(dbt4001.get当初認定有効開始年月日());
            dataPass.set当初認定有効終了年月日(dbt4001.get当初認定有効終了年月日());
            dataPass.set受給資格証明書発行年月日１(dbt4001.get受給資格証明書発行年月日１());
            dataPass.set受給資格証明書発行年月日２(dbt4001.get受給資格証明書発行年月日２());
            dataPass.set市町村コード(dbt4001.get市町村コード());
            dataPass.set申請書管理番号(dbt4001.get申請書管理番号());
        }
        if (dbt4102 != null) {
            dataPass.set介護認定審査会意見(dbt4102.get介護認定審査会意見());
            dataPass.set介護認定審査会資料作成年月日(new RDate(dbt4102.get介護認定審査会資料作成年月日().getYearValue(),
                    dbt4102.get介護認定審査会資料作成年月日().getMonthValue(), dbt4102.get介護認定審査会資料作成年月日().getDayValue()));
            dataPass.set二次判定年月日(new RDate(dbt4102.get二次判定年月日().getYearValue(),
                    dbt4102.get二次判定年月日().getMonthValue(), dbt4102.get二次判定年月日().getDayValue()));
            dataPass.set二次判定要介護状態区分コード(Code.EMPTY);
            dataPass.set二次判定認定有効期間(dbt4102.get二次判定認定有効期間());
            dataPass.set二次判定認定有効開始年月日(dbt4102.get二次判定認定有効開始年月日());
            dataPass.set二次判定認定有効終了年月日(dbt4102.get二次判定認定有効終了年月日());
        }
        if (dbt4101 != null) {
            dataPass.set要介護申請_要支援申請の区分(dbt4101.get要介護申請_要支援申請の区分());
            dataPass.set認定申請年月日(dbt4101.get認定申請年月日());
            dataPass.set認定申請区分_法令_コード(dbt4101.get認定申請区分_法令_コード());
            dataPass.set認定申請区分_申請時_コード(dbt4101.get認定申請区分_申請時_コード());
            dataPass.set被保険者区分コード(dbt4101.get被保険者区分コード());
            dataPass.set二号特定疾病コード(dbt4101.get２号特定疾病コード());
            dataPass.set支所コード(dbt4101.get支所コード());
            dataPass.set認定申請理由(dbt4101.get認定申請理由());
            dataPass.set取下年月日(dbt4101.get取下年月日());
            dataPass.set指定医フラグ(dbt4101.is指定医フラグ());
            dataPass.set訪問調査先名称(dbt4101.get訪問調査先名称());
            dataPass.set訪問調査先郵便番号(dbt4101.get訪問調査先郵便番号());
            dataPass.set訪問調査先住所(dbt4101.get訪問調査先住所());
            dataPass.set訪問調査先電話番号(dbt4101.get訪問調査先電話番号());
            dataPass.set延期通知発行年月日(new RDate(dbt4101.get延期通知発行年月日().getYearValue(),
                    dbt4101.get延期通知発行年月日().getMonthValue(), dbt4101.get延期通知発行年月日().getDayValue()));
            dataPass.set延期通知発行回数(dbt4101.get延期通知発行回数());
            dataPass.set厚労省IF識別コード(厚労省IF識別コード);
        }
        if (dbt4120 != null) {
            dataPass.set届出代行区分(dbt4120.get申請届出代行区分コード());
            dataPass.set氏名(dbt4120.get申請届出者氏名());
            dataPass.setカナ氏名(dbt4120.get申請届出者氏名カナ());
            dataPass.set本人との関係性(dbt4120.get申請届出者続柄());
            dataPass.set事業者番号(dbt4120.get申請届出代行事業者番号());
            dataPass.set事業者区分(dbt4120.get事業者区分());
            dataPass.set郵便番号(dbt4120.get申請届出者郵便番号());
            dataPass.set住所(dbt4120.get申請届出者住所());
            dataPass.set電話番号(dbt4120.get申請届出者電話番号());
        }
        if (dbt4913Entity != null) {
            dataPass.set認定調査員コード(dbt4913Entity.getNinteiChosainCode());
            dataPass.set調査員氏名(dbt4913Entity.getChosainShimei());
        }
        if (dbt4910Entity != null) {
            dataPass.set認定調査委託先コード(dbt4910Entity.getNinteichosaItakusakiCode().value());
            dataPass.set事業者名称(dbt4910Entity.getJigyoshaMeisho());
            dataPass.set認定郵便番号(dbt4910Entity.getYubinNo());
            dataPass.set認定住所(dbt4910Entity.getJusho());
            dataPass.set認定電話番号(dbt4910Entity.getTelNo());
            dataPass.set調査委託区分(dbt4910Entity.getChosaItakuKubun());
        }
        if (dbt4201 != null) {
            dataPass.set認定調査依頼年月日(new RDate(dbt4201.get認定調査依頼年月日().getYearValue(),
                    dbt4201.get認定調査依頼年月日().getMonthValue(), dbt4201.get認定調査依頼年月日().getDayValue()));
        }
        if (dbt4123 != null) {
            dataPass.set認定調査予定年月日(new RDate(dbt4123.get認定調査予定年月日().getYearValue(),
                    dbt4123.get認定調査予定年月日().getMonthValue(), dbt4123.get認定調査予定年月日().getDayValue()));
            dataPass.set主治医意見書登録予定年月日(new RDate(dbt4123.get主治医意見書登録予定年月日().getYearValue(),
                    dbt4123.get主治医意見書登録予定年月日().getMonthValue(), dbt4123.get主治医意見書登録予定年月日().getDayValue()));
            dataPass.set認定審査会予定年月日(new RDate(dbt4123.get認定審査会予定年月日().getDayValue()));
        }
        if (dbt4202 != null) {
            dataPass.set認定調査実施年月日(new RDate(dbt4202.get認定調査実施年月日().getYearValue(),
                    dbt4202.get認定調査実施年月日().getMonthValue(), dbt4202.get認定調査実施年月日().getDayValue()));
        }
        if (dbt4912Entity != null) {
            dataPass.set主治医コード(dbt4912Entity.getShujiiCode());
            dataPass.set主治医氏名(dbt4912Entity.getShujiiName());
        }
        if (dbt4911Entity != null) {
            dataPass.set主治医医療機関コード(dbt4911Entity.getShujiiIryokikanCode().getColumnValue());
            dataPass.set医療機関名称(dbt4911Entity.getIryoKikanMeisho());
            dataPass.set主治医郵便番号(dbt4911Entity.getYubinNo());
            dataPass.set主治医住所(dbt4911Entity.getJusho());
            dataPass.set主治医電話番号(dbt4911Entity.getTelNo());
        }
        if (dbt4301 != null) {
            dataPass.set主治医意見書作成依頼年月日(new RDate(dbt4301.get主治医意見書作成依頼年月日().getYearValue(),
                    dbt4301.get主治医意見書作成依頼年月日().getMonthValue(), dbt4301.get主治医意見書作成依頼年月日().getDayValue()));
        }
        if (dbt4302 != null) {
            dataPass.set主治医意見書記入年月日(new RDate(dbt4302.get主治医意見書記入年月日().getYearValue(),
                    dbt4302.get主治医意見書記入年月日().getMonthValue(), dbt4302.get主治医意見書記入年月日().getDayValue()));
        }
        if (dbt4116 != null) {
            dataPass.set要介護認定一次判定結果コード(Code.EMPTY);
            dataPass.set要介護認定一次判定年月日(new RDate(dbt4116.get要介護認定一次判定年月日().getYearValue(),
                    dbt4116.get要介護認定一次判定年月日().getMonthValue(), dbt4116.get要介護認定一次判定年月日().getDayValue()));
            dataPass.set要介護認定一次判定結果コード_認知症加算(Code.EMPTY);
        }
        return dataPass;
    }
}
