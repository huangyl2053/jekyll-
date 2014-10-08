/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReport;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧の内部帳票を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorInternalReport implements IInternalReport {

    private final IInternalReportCommon reportCommon;
    private final FukaErrorInternalReportItemList itemList;

    /**
     * 引数から賦課エラー一覧の要素を受け取り、インスタンスを生成します。
     *
     * @param reportCommon 内部帳票共通情報
     * @param itemList 内部帳票項目List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public FukaErrorInternalReport(IInternalReportCommon reportCommon, FukaErrorInternalReportItemList itemList) throws NullPointerException {
        requireNonNull(reportCommon, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("内部帳票共通情報", getClass().getName()));
        requireNonNull(itemList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("内部帳票項目List", getClass().getName()));
        this.reportCommon = reportCommon;
        this.itemList = itemList;
    }

    /**
     * 自身が持つ賦課エラー一覧情報のListを返します。
     *
     * @return 賦課エラーList
     */
    public FukaErrorInternalReportItemList get賦課エラーList() {
        return itemList;
    }

    @Override
    public List<FukaErrorInternalReportItem> getInternalReportItemList() {
        return itemList.toList();
    }

    @Override
    public SubGyomuCode getサブ業務コード() {
        return reportCommon.getサブ業務コード();
    }

    @Override
    public RString get内部帳票Id() {
        return reportCommon.get内部帳票Id();
    }

    @Override
    public RString get内部帳票名() {
        return reportCommon.get内部帳票名();
    }

    @Override
    public RDateTime get内部帳票作成日時() {
        return reportCommon.get内部帳票作成日時();
    }

    @Override
    public RString getバッチId() {
        return reportCommon.getバッチId();
    }

    @Override
    public RString getバッチ名() {
        return reportCommon.getバッチ名();
    }

    @Override
    public RDateTime getバッチ起動日時() {
        return reportCommon.getバッチ起動日時();
    }

}
