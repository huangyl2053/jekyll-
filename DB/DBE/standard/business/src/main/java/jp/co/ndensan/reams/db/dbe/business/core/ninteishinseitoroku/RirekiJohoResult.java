/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.RirekiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 審査依頼受付／みなし２号審査受付のビジネスクラスです
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class RirekiJohoResult {
    
    private final NinteiChosaJokyoDataPass 今回履歴情報;
    private final NinteiChosaJokyoDataPass 前回履歴情報;

    /**
     * コンストラクタです。
     *
     * @param johoList 履歴情報
     */
    public RirekiJohoResult(List<RirekiJohoRelateEntity> johoList) {
        if (johoList != null && !johoList.isEmpty()) {
            if (johoList.size() == 2) {
                今回履歴情報 = set履歴情報(johoList.get(0));
                前回履歴情報 = set履歴情報(johoList.get(1));
            } else {
                今回履歴情報 = set履歴情報(johoList.get(0));
                前回履歴情報 = new NinteiChosaJokyoDataPass();
            }
        } else {
            今回履歴情報 = new NinteiChosaJokyoDataPass();
            前回履歴情報 = new NinteiChosaJokyoDataPass();
        }
    }

    /**
     * 今回履歴情報を取得します。
     *
     * @return 今回履歴情報
     */
    public NinteiChosaJokyoDataPass get今回履歴情報() {
        return 今回履歴情報;
    }

    /**
     * 前回履歴情報を取得します。
     *
     * @return 前回履歴情報
     */
    public NinteiChosaJokyoDataPass get前回履歴情報() {
        return 前回履歴情報;
    }
    
    private NinteiChosaJokyoDataPass set履歴情報(RirekiJohoRelateEntity entity) {
        NinteiChosaJokyoDataPass dataPass = new NinteiChosaJokyoDataPass();
        dataPass.set認定調査員コード(entity.get認定調査員コード());
        dataPass.set調査員氏名(entity.get調査員氏名());
        dataPass.set認定調査委託先コード(entity.get認定調査委託先コード());
        dataPass.set事業者名称(entity.get事業者名称());
        dataPass.set認定郵便番号(entity.get認定郵便番号());
        dataPass.set認定住所(entity.get認定住所());
        dataPass.set認定電話番号(entity.get認定電話番号());
        dataPass.set認定調査依頼年月日(flexibleDateToRDate(entity.get認定調査依頼年月日()));
        dataPass.set認定調査予定年月日(flexibleDateToRDate(entity.get認定調査予定年月日()));
        dataPass.set認定調査実施年月日(flexibleDateToRDate(entity.get認定調査実施年月日()));
        dataPass.set調査委託区分(entity.get調査委託区分());
        dataPass.set訪問調査先名称(entity.get訪問調査先名称());
        dataPass.set訪問調査先郵便番号(entity.get訪問調査先郵便番号());
        dataPass.set訪問調査先住所(entity.get訪問調査先住所());
        dataPass.set訪問調査先電話番号(entity.get訪問調査先電話番号());
        dataPass.set主治医コード(entity.get主治医コード());
        dataPass.set主治医氏名(entity.get主治医氏名());
        dataPass.set主治医医療機関コード(entity.get主治医医療機関コード());
        dataPass.set医療機関名称(entity.get医療機関名称());
        dataPass.set主治医郵便番号(entity.get主治医郵便番号());
        dataPass.set主治医住所(entity.get主治医住所());
        dataPass.set主治医電話番号(entity.get主治医電話番号());
        dataPass.set主治医意見書作成依頼年月日(flexibleDateToRDate(entity.get主治医意見書作成依頼年月日()));
        dataPass.set主治医意見書登録予定年月日(flexibleDateToRDate(entity.get主治医意見書登録予定年月日()));
        dataPass.set主治医意見書記入年月日(flexibleDateToRDate(entity.get主治医意見書記入年月日()));
        dataPass.set指定医フラグ(entity.is指定医フラグ());
        dataPass.set要介護認定一次判定結果コード(entity.get要介護認定一次判定結果コード());
        dataPass.set要介護認定一次判定年月日(flexibleDateToRDate(entity.get要介護認定一次判定年月日()));
        dataPass.set要介護認定一次判定結果コード_認知症加算(entity.get要介護認定一次判定結果コード_認知症加算());
        dataPass.set介護認定審査会資料作成年月日(flexibleDateToRDate(entity.get介護認定審査会資料作成年月日()));
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
            return RDate.MIN;
        }
        return new RDate(date.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString().toString());
    }
}
