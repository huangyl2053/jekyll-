/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護履歴情報です。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public class YokaigoRirekiJoho {

    private final YokaigoRirekiJohoEntity entity;
    private final DbT4101NinteiShinseiJohoEntity 要介護認定申請情報受給Entity;
    private final DbT4910NinteichosaItakusakiJohoEntity 認定調査委託先情報Entity;
    private final DbT4911ShujiiIryoKikanJohoEntity 主治医医療機関情報受給Entity;
    private final DbT4912ShujiiJohoEntity 主治医情報受給Entity;
    private final DbT4913ChosainJohoEntity 調査員情報Entity;
    private final DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;
    private final DbT4201NinteichosaIraiJohoEntity 認定調査依頼情報Entity;
    private final DbT4301ShujiiIkenshoIraiJohoEntity 主治医意見書作成依頼情報Entity;
    private final DbT4123NinteiKeikakuJohoEntity 要介護認定計画情報Entity;
    private final DbT4116IchijiHanteiKekkaJohoEntity 要介護認定一次判定結果情報Entity;

    /**
     * コンストラクタです。<br/>
     *
     * @param entity YokaigoRirekiJohoEntity
     */
    public YokaigoRirekiJoho(YokaigoRirekiJohoEntity entity) {
        this.entity = entity;
        this.要介護認定申請情報受給Entity = this.entity.get要介護認定申請情報受給Entity();
        this.認定調査委託先情報Entity = this.entity.get認定調査委託先情報Entity();
        this.主治医医療機関情報受給Entity = this.entity.get主治医医療機関情報受給Entity();
        this.主治医情報受給Entity = this.entity.get主治医情報受給Entity();
        this.調査員情報Entity = this.entity.get調査員情報Entity();
        this.要介護認定結果情報Entity = this.entity.get要介護認定結果情報Entity();
        this.認定調査依頼情報Entity = this.entity.get認定調査依頼情報Entity();
        this.主治医意見書作成依頼情報Entity = this.entity.get主治医意見書作成依頼情報Entity();
        this.要介護認定計画情報Entity = this.entity.get要介護認定計画情報Entity();
        this.要介護認定一次判定結果情報Entity = this.entity.get要介護認定一次判定結果情報Entity();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード RString
     */
    public RString get認定調査員コード() {
        return null == 調査員情報Entity ? RString.EMPTY : 調査員情報Entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名 RString
     */
    public RString get調査員氏名() {
        return null == 調査員情報Entity ? RString.EMPTY : 調査員情報Entity.getChosainShimei();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード ChosaItakusakiCode
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return null == 認定調査委託先情報Entity ? ChosaItakusakiCode.EMPTY : 認定調査委託先情報Entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称 RString
     */
    public RString get事業者名称() {
        return null == 認定調査委託先情報Entity ? RString.EMPTY : 認定調査委託先情報Entity.getJigyoshaMeisho();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号 YubinNo
     */
    public YubinNo get郵便番号() {
        return null == 認定調査委託先情報Entity ? YubinNo.EMPTY : 認定調査委託先情報Entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所 RString
     */
    public RString get住所() {
        return null == 認定調査委託先情報Entity ? RString.EMPTY : 認定調査委託先情報Entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号 FlexibleDate
     */
    public TelNo get電話番号() {
        return null == 認定調査委託先情報Entity ? TelNo.EMPTY : 認定調査委託先情報Entity.getTelNo();
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日 FlexibleDate
     */
    public FlexibleDate get認定調査依頼年月日() {
        return null == 認定調査依頼情報Entity ? FlexibleDate.EMPTY : 認定調査依頼情報Entity.getNinteichosaIraiYMD();
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日 FlexibleDate
     */
    public FlexibleDate get認定調査予定年月日() {
        return null == 要介護認定計画情報Entity ? FlexibleDate.EMPTY : 要介護認定計画情報Entity.getNinteichosaIraiYoteiYMD();
    }

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分 RString
     */
    public RString get調査委託区分() {
        return null == 認定調査委託先情報Entity ? RString.EMPTY : 認定調査委託先情報Entity.getChosaItakuKubun();
    }

    /**
     * 訪問調査先名称を返します。
     *
     * @return 訪問調査先名称 AtenaMeisho
     */
    public AtenaMeisho get訪問調査先名称() {
        return null == 要介護認定申請情報受給Entity ? AtenaMeisho.EMPTY : 要介護認定申請情報受給Entity.getHomonChosasakiName();
    }

    /**
     * 訪問調査先郵便番号を返します。
     *
     * @return 訪問調査先郵便番号 YubinNo
     */
    public YubinNo get訪問調査先郵便番号() {
        return null == 要介護認定申請情報受給Entity ? YubinNo.EMPTY : 要介護認定申請情報受給Entity.getHomonChosasakiYubinNo();
    }

    /**
     * 訪問調査先住所を返します。
     *
     * @return 訪問調査先住所 AtenaJusho
     */
    public AtenaJusho get訪問調査先住所() {
        return null == 要介護認定申請情報受給Entity ? AtenaJusho.EMPTY : 要介護認定申請情報受給Entity.getHomonChosasakiJusho();
    }

    /**
     * 訪問調査先電話番号を返します。
     *
     * @return 訪問調査先電話番号 TelNo
     */
    public TelNo get訪問調査先電話番号() {
        return null == 要介護認定申請情報受給Entity ? TelNo.EMPTY : 要介護認定申請情報受給Entity.getHomonChosasakiTelNo();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード RString
     */
    public RString get主治医コード() {
        return null == 主治医情報受給Entity ? RString.EMPTY : 主治医情報受給Entity.getShujiiCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名 RString
     */
    public RString get主治医氏名() {
        return null == 主治医情報受給Entity ? RString.EMPTY : 主治医情報受給Entity.getShujiiName();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード RString
     */
    public RString get主治医医療機関コード() {
        return null == 主治医医療機関情報受給Entity ? RString.EMPTY : 主治医医療機関情報受給Entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称 RString
     */
    public RString get医療機関名称() {
        return null == 主治医医療機関情報受給Entity ? RString.EMPTY : 主治医医療機関情報受給Entity.getIryoKikanMeisho();
    }

    /**
     * 主治医意見書作成依頼年月日を返します。
     *
     * @return 主治医意見書作成依頼年月日 FlexibleDate
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return null == 主治医意見書作成依頼情報Entity ? FlexibleDate.EMPTY : 主治医意見書作成依頼情報Entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 主治医意見書登録予定年月日を返します。
     *
     * @return 主治医意見書登録予定年月日 FlexibleDate
     */
    public FlexibleDate get主治医意見書登録予定年月日() {
        return null == 要介護認定計画情報Entity ? FlexibleDate.EMPTY : 要介護認定計画情報Entity.getIkenshoTorokuYoteiYMD();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ FlexibleDate
     */
    public Boolean get指定医フラグ() {
        return null == 主治医情報受給Entity ? null : 主治医情報受給Entity.getShiteiiFlag();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード Code
     */
    public Code get要介護認定一次判定結果コード() {
        return null == 要介護認定一次判定結果情報Entity ? Code.EMPTY : 要介護認定一次判定結果情報Entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 要介護認定一次判定年月日を返します。
     *
     * @return 要介護認定一次判定年月日 FlexibleDate
     */
    public FlexibleDate get要介護認定一次判定年月日() {
        return null == 要介護認定一次判定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定一次判定結果情報Entity.getIchijiHanteiYMD();
    }

    /**
     * 要介護認定一次判定結果コード（認知症加算）を返します。
     *
     * @return 要介護認定一次判定結果コード（認知症加算） Code
     */
    public Code get要介護認定一次判定結果コード認知症加算() {
        return null == 要介護認定一次判定結果情報Entity ? Code.EMPTY : 要介護認定一次判定結果情報Entity.getIchijiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * 介護認定審査会資料作成年月日を返します。
     *
     * @return 介護認定審査会資料作成年月日 FlexibleDate
     */
    public FlexibleDate get介護認定審査会資料作成年月日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 認定審査会予定年月日を返します。
     *
     * @return 認定審査会予定年月日 FlexibleDate
     */
    public FlexibleDate get認定審査会予定年月日() {
        return null == 要介護認定計画情報Entity ? FlexibleDate.EMPTY : 要介護認定計画情報Entity.getNinteiShinsakaiYoteiYMD();
    }

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日 FlexibleDate
     */
    public FlexibleDate get二次判定年月日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード Code
     */
    public Code get二次判定要介護状態区分コード() {
        return null == 要介護認定結果情報Entity ? Code.EMPTY : 要介護認定結果情報Entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間 Integer
     */
    public Integer get二次判定認定有効期間() {
        return null == 要介護認定結果情報Entity ? null : 要介護認定結果情報Entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日 FlexibleDate
     */
    public FlexibleDate get二次判定認定有効開始年月日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日 FlexibleDate
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 延期通知発行年月日を返します。
     *
     * @return 延期通知発行年月日 FlexibleDate
     */
    public FlexibleDate get延期通知発行年月日() {
        return null == 要介護認定申請情報受給Entity ? FlexibleDate.EMPTY : 要介護認定申請情報受給Entity.getEnkiTsuchiHakkoYMD();
    }

    /**
     * 延期通知発行回数を返します。
     *
     * @return 延期通知発行回数 Integer
     */
    public Integer get延期通知発行回数() {
        return null == 要介護認定申請情報受給Entity ? null : 要介護認定申請情報受給Entity.getEnkiTsuchiHakkoKaisu();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号 ShinseishoKanriNo
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return null == 要介護認定申請情報受給Entity ? ShinseishoKanriNo.EMPTY : 要介護認定申請情報受給Entity.getShinseishoKanriNo();
    }
}
