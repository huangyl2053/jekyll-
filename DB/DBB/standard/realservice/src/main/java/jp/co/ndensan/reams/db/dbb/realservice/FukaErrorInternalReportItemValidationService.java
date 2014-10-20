/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidationMessages;
import static jp.co.ndensan.reams.ur.urz.business.validations.ValidationChain.validateFollowingItems;

/**
 * 賦課エラー一覧情報に対するValidationを提供するサービスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorInternalReportItemValidationService implements IValidatable {

    private final FukaErrorInternalReportItem internalReportItem;
    private final FukaErrorInternalReportService service;

    /**
     * 引数から、バリデーションチェックの対象となる賦課エラー一覧の1行分のデータを受け取り、インスタンスを生成します。
     *
     * @param internalReportItem 賦課エラー一覧、1行分のデータ
     */
    public FukaErrorInternalReportItemValidationService(FukaErrorInternalReportItem internalReportItem) {
        this.internalReportItem = internalReportItem;
        this.service = new FukaErrorInternalReportService();
    }

    /**
     * 引数からモックインスタンスを受け取る、テスト用コンストラクタです。
     *
     * @param internalReportItem 賦課エラー一覧ItemMock
     * @param dac 賦課エラーDacMock
     */
    FukaErrorInternalReportItemValidationService(FukaErrorInternalReportItem internalReportItem, FukaErrorInternalReportService service) {
        this.internalReportItem = internalReportItem;
        this.service = service;
    }

    @Override
    public IValidationMessages validate() {
        return validateFollowingItems()
                .then(処理状態が未処理以外())
                .end();
    }

    private IValidationMessages 処理状態が未処理以外() {
        FukaErrorInternalReportItem newestItem = service.getFukaErrorInternalReportItem(internalReportItem.get賦課年度(),
                internalReportItem.get通知書番号());
        return newestItem.validate();
    }
}
