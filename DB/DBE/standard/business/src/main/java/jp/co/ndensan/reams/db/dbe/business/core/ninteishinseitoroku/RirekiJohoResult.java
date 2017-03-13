/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.RirekiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 審査依頼受付／みなし２号審査受付のビジネスクラスです
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class RirekiJohoResult {

    private final NinteiChosaJokyoDataPass 申請情報;

    /**
     * コンストラクタです。
     *
     * @param rirekiJohoRelateEntity 申請情報
     */
    public RirekiJohoResult(RirekiJohoRelateEntity rirekiJohoRelateEntity) {
        if (rirekiJohoRelateEntity != null) {
            申請情報 = set履歴情報(rirekiJohoRelateEntity);
        } else {
            申請情報 = new NinteiChosaJokyoDataPass();
        }
    }

    /**
     * 申請情報を取得します。
     *
     * @return 申請情報
     */
    public NinteiChosaJokyoDataPass get申請情報() {
        return 申請情報;
    }

    private NinteiChosaJokyoDataPass set履歴情報(RirekiJohoRelateEntity entity) {
        NinteiChosaJokyoDataPass dataPass = new NinteiChosaJokyoDataPass();
        if (!RString.isNullOrEmpty(entity.get認定調査委託先コード_結果())) {
            dataPass.set認定調査員コード(entity.get認定調査員コード_結果());
            dataPass.set調査員氏名(entity.get調査員氏名_結果());
            dataPass.set認定調査委託先コード(entity.get認定調査委託先コード_結果());
            dataPass.set事業者名称(entity.get事業者名称_結果());
            dataPass.set認定郵便番号(entity.get認定郵便番号_結果());
            dataPass.set認定住所(entity.get認定住所_結果());
            dataPass.set認定電話番号(entity.get認定電話番号_結果());
            dataPass.set調査委託区分(entity.get調査委託区分_結果());
        } else if (!RString.isNullOrEmpty(entity.get認定調査委託先コード_依頼())) {
            dataPass.set認定調査員コード(entity.get認定調査員コード_依頼());
            dataPass.set調査員氏名(entity.get調査員氏名_依頼());
            dataPass.set認定調査委託先コード(entity.get認定調査委託先コード_依頼());
            dataPass.set事業者名称(entity.get事業者名称_依頼());
            dataPass.set認定郵便番号(entity.get認定郵便番号_依頼());
            dataPass.set認定住所(entity.get認定住所_依頼());
            dataPass.set認定電話番号(entity.get認定電話番号_依頼());
            dataPass.set調査委託区分(entity.get調査委託区分_依頼());
        } else {
            dataPass.set認定調査員コード(entity.get認定調査員コード_申請());
            dataPass.set調査員氏名(entity.get調査員氏名_申請());
            dataPass.set認定調査委託先コード(entity.get認定調査委託先コード_申請());
            dataPass.set事業者名称(entity.get事業者名称_申請());
            dataPass.set認定郵便番号(entity.get認定郵便番号_申請());
            dataPass.set認定住所(entity.get認定住所_申請());
            dataPass.set認定電話番号(entity.get認定電話番号_申請());
            dataPass.set調査委託区分(entity.get調査委託区分_申請());
        }
        dataPass.set認定調査依頼年月日(flexibleDateToRDate(entity.get認定調査依頼年月日()));
        dataPass.set認定調査予定年月日(flexibleDateToRDate(entity.get認定調査予定年月日()));
        dataPass.set認定調査実施年月日(flexibleDateToRDate(entity.get認定調査実施年月日()));
        dataPass.set訪問調査先名称(entity.get訪問調査先名称());
        dataPass.set訪問調査先郵便番号(entity.get訪問調査先郵便番号());
        dataPass.set訪問調査先住所(entity.get訪問調査先住所());
        dataPass.set訪問調査先電話番号(entity.get訪問調査先電話番号());
        if (!RString.isNullOrEmpty(entity.get主治医医療機関コード_結果())) {
            dataPass.set主治医コード(entity.get主治医コード_結果());
            dataPass.set主治医氏名(entity.get主治医氏名_結果());
            dataPass.set指定医フラグ(entity.is指定医フラグ_結果());
            dataPass.set主治医医療機関コード(entity.get主治医医療機関コード_結果());
            dataPass.set医療機関名称(entity.get医療機関名称_結果());
            dataPass.set主治医郵便番号(entity.get主治医郵便番号_結果());
            dataPass.set主治医住所(entity.get主治医住所_結果());
            dataPass.set主治医電話番号(entity.get主治医電話番号_結果());
        } else if (!RString.isNullOrEmpty(entity.get主治医医療機関コード_依頼())) {
            dataPass.set主治医コード(entity.get主治医コード_依頼());
            dataPass.set主治医氏名(entity.get主治医氏名_依頼());
            dataPass.set指定医フラグ(entity.is指定医フラグ_依頼());
            dataPass.set主治医医療機関コード(entity.get主治医医療機関コード_依頼());
            dataPass.set医療機関名称(entity.get医療機関名称_依頼());
            dataPass.set主治医郵便番号(entity.get主治医郵便番号_依頼());
            dataPass.set主治医住所(entity.get主治医住所_依頼());
            dataPass.set主治医電話番号(entity.get主治医電話番号_依頼());
        } else {
            dataPass.set主治医コード(entity.get主治医コード_申請());
            dataPass.set主治医氏名(entity.get主治医氏名_申請());
            dataPass.set指定医フラグ(entity.is指定医フラグ_申請());
            dataPass.set主治医医療機関コード(entity.get主治医医療機関コード_申請());
            dataPass.set医療機関名称(entity.get医療機関名称_申請());
            dataPass.set主治医郵便番号(entity.get主治医郵便番号_申請());
            dataPass.set主治医住所(entity.get主治医住所_申請());
            dataPass.set主治医電話番号(entity.get主治医電話番号_申請());
        }
        dataPass.set主治医意見書作成依頼年月日(flexibleDateToRDate(entity.get主治医意見書作成依頼年月日()));
        dataPass.set主治医意見書登録予定年月日(flexibleDateToRDate(entity.get主治医意見書登録予定年月日()));
        dataPass.set主治医意見書記入年月日(flexibleDateToRDate(entity.get主治医意見書記入年月日()));
        dataPass.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
        dataPass.set要介護認定一次判定年月日(flexibleDateToRDate(entity.get要介護認定一次判定年月日()));
        dataPass.set要介護認定一次判定結果コード_認知症加算(entity.get要介護認定一次判定結果コード_認知症加算());
        if (entity.get介護認定審査会資料作成年月日_DbT5102() != null && !entity.get介護認定審査会資料作成年月日_DbT5102().isEmpty()) {
            dataPass.set介護認定審査会資料作成年月日(flexibleDateToRDate(entity.get介護認定審査会資料作成年月日_DbT5102()));
        } else {
            dataPass.set介護認定審査会資料作成年月日(flexibleDateToRDate(entity.get介護認定審査会資料作成年月日_DbT5502()));
        }
        dataPass.set認定審査会予定年月日(flexibleDateToRDate(entity.get認定審査会予定年月日()));
        dataPass.set二次判定年月日(flexibleDateToRDate(entity.get二次判定年月日()));
        dataPass.set二次判定要介護状態区分コード(entity.get二次判定要介護状態区分コード());
        dataPass.set二次判定認定有効期間(entity.get二次判定認定有効期間());
        dataPass.set二次判定認定有効開始年月日(entity.get二次判定認定有効開始年月日());
        dataPass.set二次判定認定有効終了年月日(entity.get二次判定認定有効終了年月日());
        dataPass.set延期通知発行年月日(flexibleDateToRDate(entity.get延期通知発行年月日()));
        dataPass.set延期通知発行回数(entity.get延期通知発行回数());
        dataPass.set申請書管理番号(entity.get申請書管理番号());
        dataPass.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        dataPass.set市町村コード(entity.get市町村コード());
        return dataPass;
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        if (date == null || FlexibleDate.EMPTY.equals(date)) {
            return null;
        }
        return new RDate(date.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString().toString());
    }
}
