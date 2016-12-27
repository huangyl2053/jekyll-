/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データパッシング用認定調査状況のBusinessクラスです
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaJokyoDataPass implements Serializable {

    private static final long serialVersionUID = -5218551860330526483L;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 認定調査委託先コード;
    private RString 事業者名称;
    private YubinNo 認定郵便番号;
    private RString 認定住所;
    private TelNo 認定電話番号;
    private RDate 認定調査依頼年月日;
    private RDate 認定調査予定年月日;
    private RDate 認定調査実施年月日;
    private RString 調査委託区分;
    private AtenaMeisho 訪問調査先名称;
    private YubinNo 訪問調査先郵便番号;
    private AtenaJusho 訪問調査先住所;
    private TelNo 訪問調査先電話番号;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private YubinNo 主治医郵便番号;
    private RString 主治医住所;
    private TelNo 主治医電話番号;
    private RDate 主治医意見書作成依頼年月日;
    private RDate 主治医意見書登録予定年月日;
    private RDate 主治医意見書記入年月日;
    private boolean 指定医フラグ;
    private Code 要介護認定一次判定結果コード;
    private RDate 要介護認定一次判定年月日;
    private Code 要介護認定一次判定結果コード_認知症加算;
    private RDate 介護認定審査会資料作成年月日;
    private RDate 認定審査会予定年月日;
    private RDate 二次判定年月日;
    private Code 二次判定要介護状態区分コード;
    private int 二次判定認定有効期間;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private RDate 延期通知発行年月日;
    private int 延期通知発行回数;
    private ShinseishoKanriNo 申請書管理番号;
    private LasdecCode 市町村コード;
    private Code 厚労省IF識別コード;

    /**
     * 認定申請情報に関連する項目に内容をセットします。
     *
     * @param 認定申請情報 認定申請情報
     */
    public void set認定申請情報(NinteiShinseiJoho 認定申請情報) {
        認定調査員コード = 認定申請情報.get認定調査員コード().value();
        訪問調査先名称 = 認定申請情報.get訪問調査先名称();
        訪問調査先郵便番号 = 認定申請情報.get訪問調査先郵便番号();
        訪問調査先住所 = 認定申請情報.get訪問調査先住所();
        訪問調査先電話番号 = 認定申請情報.get訪問調査先電話番号();
        主治医コード = 認定申請情報.get主治医コード();
        主治医医療機関コード = 認定申請情報.get主治医医療機関コード();
        指定医フラグ = 認定申請情報.is指定医フラグ();
        延期通知発行年月日 = convertToRDate(認定申請情報.get延期通知発行年月日());
        延期通知発行回数 = 認定申請情報.get延期通知発行回数();
        申請書管理番号 = 認定申請情報.get申請書管理番号();
        厚労省IF識別コード = 認定申請情報.get厚労省IF識別コード();

    }

    /**
     * 認定調査依頼情報に関連する項目に内容をセットします。
     *
     * @param 認定調査依頼情報 認定調査依頼情報
     */
    public void set認定調査依頼情報(NinteichosaIraiJoho 認定調査依頼情報) {
        認定調査員コード = 認定調査依頼情報.get認定調査員コード();
        認定調査委託先コード = 認定調査依頼情報.get認定調査委託先コード().value();
        認定調査依頼年月日 = convertToRDate(認定調査依頼情報.get認定調査依頼年月日());
        認定調査予定年月日 = convertToRDate(認定調査依頼情報.get認定調査期限年月日());
    }

    /**
     * 認定調査票概況調査_子に関連する項目に内容をセットします。
     *
     * @param 認定調査票概況調査_子 認定調査票概況調査_子
     */
    public void set認定調査票概況調査_子(NinteichosahyoGaikyoChosa 認定調査票概況調査_子) {
        認定調査実施年月日 = convertToRDate(認定調査票概況調査_子.get認定調査実施年月日());
    }

    /**
     * 認定調査委託先情報に関連する項目に内容をセットします。
     *
     * @param 認定調査委託先情報 認定調査委託先情報
     */
    public void set認定調査委託先情報(NinteichosaItakusakiJoho 認定調査委託先情報) {
        事業者名称 = 認定調査委託先情報.get事業者名称();
        認定郵便番号 = 認定調査委託先情報.get郵便番号();
        認定住所 = 認定調査委託先情報.get住所();
        認定電話番号 = 認定調査委託先情報.get電話番号();
        調査委託区分 = 認定調査委託先情報.get調査委託区分();
    }

    /**
     * 調査員情報に関連する項目に内容をセットします。
     *
     * @param 調査員情報 調査員情報
     */
    public void set認定調査員情報(ChosainJoho 調査員情報) {
        認定調査員コード = 調査員情報.get認定調査員コード();
        調査員氏名 = 調査員情報.get調査員氏名();
    }

    /**
     * 主治医医療機関情報に関連する項目に内容をセットします。
     *
     * @param 主治医医療機関情報 主治医医療機関情報
     */
    public void set主治医医療機関情報(ShujiiIryoKikanJoho 主治医医療機関情報) {
        主治医医療機関コード = 主治医医療機関情報.get主治医医療機関コード().value();
        医療機関名称 = 主治医医療機関情報.get医療機関名称();
        主治医郵便番号 = 主治医医療機関情報.get郵便番号();
        主治医住所 = 主治医医療機関情報.get住所();
        主治医電話番号 = 主治医医療機関情報.get電話番号();
    }

    /**
     * 主治医情報に関連する項目に内容をセットします。
     *
     * @param 主治医情報 主治医情報
     */
    public void set主治医情報(ShujiiJoho 主治医情報) {
        主治医コード = 主治医情報.get主治医コード();
        主治医氏名 = 主治医情報.get主治医氏名();
    }

    /**
     * 主治医意見書作成依頼情報に関連する項目に内容をセットします。
     *
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     */
    public void set主治医意見書作成依頼情報(ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報) {
        主治医意見書作成依頼年月日 = convertToRDate(主治医意見書作成依頼情報.get主治医意見書作成依頼年月日());
        主治医意見書登録予定年月日 = convertToRDate(主治医意見書作成依頼情報.get主治医意見書作成期限年月日());
    }

    /**
     * 要介護認定主治医意見書情報に関連する項目に内容をセットします。
     *
     * @param 要介護認定主治医意見書情報 要介護認定主治医意見書情報
     */
    public void set要介護認定主治医意見書情報(ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        主治医意見書記入年月日 = convertToRDate(要介護認定主治医意見書情報.get主治医意見書受領年月日());
    }

    /**
     * 要介護認定一次判定結果情報に関連する項目に内容をセットします。
     *
     * @param 要介護認定一次判定結果情報entity 要介護認定一次判定結果情報entity
     */
    public void set要介護認定一次判定結果情報(DbT5116IchijiHanteiKekkaJohoEntity entity) {
        要介護認定一次判定結果コード = entity.getIchijiHanteiKekkaCode();
        要介護認定一次判定年月日 = convertToRDate(entity.getIchijiHanteiYMD());
        要介護認定一次判定結果コード_認知症加算 = entity.getIchijiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * 要介護認定結果情報に関連する項目に内容をセットします。
     *
     * @param 要介護認定結果情報 要介護認定結果情報
     */
    public void set要介護認定結果情報(NinteiKekkaJoho 要介護認定結果情報) {
        介護認定審査会資料作成年月日 = convertToRDate(要介護認定結果情報.get介護認定審査会資料作成年月日());
        二次判定年月日 = convertToRDate(要介護認定結果情報.get二次判定年月日());
        二次判定要介護状態区分コード = 要介護認定結果情報.get二次判定要介護状態区分コード();
        二次判定認定有効期間 = 要介護認定結果情報.get二次判定認定有効期間();
        二次判定認定有効開始年月日 = 要介護認定結果情報.get二次判定認定有効開始年月日();
        二次判定認定有効終了年月日 = 要介護認定結果情報.get二次判定認定有効終了年月日();
    }

    private static RDate convertToRDate(FlexibleDate オリジナル) {
        return (オリジナル == null || オリジナル.isEmpty()) ? null : new RDate(オリジナル.toString());
    }

}
