/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.fukaerror;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReport;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧のReportクラスです。
 */
public class FukaErrorListCsvReport implements IInternalReport {

    private final IInternalReportCommon reportCommon;
    private final FukaErrorListCsvItemList itemList;

    /**
     * コンストラクタです。
     *
     * @param reportCommon 内部帳票共通情報
     * @param itemList 内部帳票項目List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public FukaErrorListCsvReport(IInternalReportCommon reportCommon, FukaErrorListCsvItemList itemList) throws NullPointerException {
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
    public FukaErrorListCsvItemList get賦課エラーList() {
        return itemList;
    }

    @Override
    public List<FukaErrorListCsvItem> getInternalReportItemList() {
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
