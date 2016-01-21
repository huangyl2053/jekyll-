/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorListBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorListIdentifier;
import jp.co.ndensan.reams.db.dbb.business.fukaerror.FukaErrorListCsvItem;
import jp.co.ndensan.reams.db.dbb.business.fukaerror.FukaErrorListCsvItemList;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.FukaErrorReportViewDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.FukaErrorShoriButtonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 賦課エラー一覧のHandlerクラスです。
 */
public class FukaErrorReportViewHandler {

    private final FukaErrorReportViewDiv div;
    private static final CodeShubetsu コード種別エラーコード = new CodeShubetsu(new RString("0009"));
    private static final RString エラーコード_更正対象 = new RString("01");
    private static final RString エラーコード_資格修正対象 = new RString("02");

    /**
     * コンストラクタです。
     *
     * @param div 賦課エラー情報Div
     */
    public FukaErrorReportViewHandler(FukaErrorReportViewDiv div) {
        this.div = div;
    }

    public void initialize(List<FukaErrorList> 賦課エラー情報) {
        set賦課エラー情報(賦課エラー情報);
        ViewStateHolder.put(ViewStateKeys.賦課エラー一覧, Models.create(賦課エラー情報));
        setButtonDisplayNone();
    }

    /**
     * グリッドのDataSourceを受け取り、賦課エラー一覧のデータにマッピングします。
     *
     * @return 賦課エラー一覧のデータ
     */
    public FukaErrorListCsvItemList toFukaErrorReportItemList() {
        List<FukaErrorListCsvItem> list = new ArrayList<>();
        for (dgFukaErrorList_Row row : div.getDgFukaErrorList().getDataSource()) {
            list.add(toFukaErrorReportItem(row));
        }
        return new FukaErrorListCsvItemList(list);
    }

    /**
     * グリッドのDataSource1行分を、賦課エラー一覧の1行分のデータにマッピングします。
     *
     * @param row グリッドのDataSource1行分
     * @return 賦課エラー一覧1行分のデータ
     */
    public FukaErrorListCsvItem toFukaErrorReportItem(dgFukaErrorList_Row row) {
        FukaErrorList fukaErrorList = new FukaErrorList(
                new SubGyomuCode(row.getSubGyomuCode()),
                row.getNaibuChohyoId(),
                new FlexibleYear(row.getFukaNendo().getValue().getYear().toDateString()),
                new TsuchishoNo(row.getTsuchishoNo()));
        FukaErrorListBuilder builder = fukaErrorList.createBuilderForEdit();
        builder.setエラーコード(new Code(row.getErrorCode()));
        builder.set処理区分コード(new Code(row.getShoriJokyoCode()));
        builder.set被保険者番号(new HihokenshaNo(row.getHihokenshaNo()));
        builder.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
        return new FukaErrorListCsvItem(builder.build());
    }

    /**
     * 選択した行のエラー内容に合わせて、修正処理へ遷移するボタンの表示非表示を切り替え、遷移可能な状態に切り替えます。
     */
    public void onSelect_dgFukaErrorList() {
        FukaErrorShoriButtonDiv buttonDiv = div.getFukaErrorShoriButton();
        setButtonDisplayNone();
        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        // TODO更正対象及び資格修正対象のコード値未確定 QA502
        if (エラーコード_更正対象.equals(row.getErrorCode())) {
            buttonDiv.getBtnFukaKosei().setDisplayNone(false);
        } else if (エラーコード_資格修正対象.equals(row.getErrorCode())) {
            buttonDiv.getBtnShikakuFuseigo().setDisplayNone(false);
        } else {
            setButtonDisplayNone();
        }
        buttonDiv.getBtnMishori().setDisplayNone(false);
        buttonDiv.setDisabled(false);
        Models<FukaErrorListIdentifier, FukaErrorList> models = ViewStateHolder.get(ViewStateKeys.賦課エラー一覧, Models.class);
        ViewStateHolder.put(ViewStateKeys.賦課エラー一覧_賦課エラー情報, models.get(
                new FukaErrorListIdentifier(new SubGyomuCode(row.getSubGyomuCode()),
                        row.getNaibuChohyoId(), new FlexibleYear(row.getFukaNendo().getValue().getYear().toDateString()),
                        new TsuchishoNo(row.getTsuchishoNo()))));
    }

    private void set賦課エラー情報(List<FukaErrorList> 賦課エラー情報) {
        List<dgFukaErrorList_Row> dataSource = new ArrayList<>();
        for (FukaErrorList fukaErrorList : 賦課エラー情報) {
            dgFukaErrorList_Row row = new dgFukaErrorList_Row();
            if (fukaErrorList.get処理区分コード() != null && !RString.EMPTY.equals(fukaErrorList.get処理区分コード().getKey())) {
                row.setShoriJokyoCode(fukaErrorList.get処理区分コード().getKey());
                row.setShoriJokyo(new RString(InternalReportShoriKubun.toValue(fukaErrorList.get処理区分コード()).name()));
            }
            if (fukaErrorList.get賦課年度() != null) {
                row.getFukaNendo().setValue(new RDate(fukaErrorList.get賦課年度().toString()));
            }
            if (fukaErrorList.get通知書番号() != null) {
                row.setTsuchishoNo(fukaErrorList.get通知書番号().value());
            }
            if (fukaErrorList.getエラーコード() != null) {
                row.setErrorCode(fukaErrorList.getエラーコード().getKey());
                row.setErrorDetail(CodeMaster.getCodeMeisho(コード種別エラーコード, fukaErrorList.getエラーコード()));
            }
            if (fukaErrorList.get被保険者番号() != null) {
                row.setHihokenshaNo(fukaErrorList.get被保険者番号().value());
            }
            if (fukaErrorList.get識別コード() != null) {
                row.setShikibetsuCode(fukaErrorList.get識別コード().value());
            }
            row.setSubGyomuCode(fukaErrorList.getサブ業務コード().value());
            row.setNaibuChohyoId(fukaErrorList.get内部帳票ID());
            dataSource.add(row);
        }
        div.getDgFukaErrorList().setDataSource(dataSource);
    }

    private void setButtonDisplayNone() {
        div.getFukaErrorShoriButton().getBtnFukaKosei().setDisplayNone(true);
        div.getFukaErrorShoriButton().getBtnShikakuFuseigo().setDisplayNone(true);
        div.getFukaErrorShoriButton().getBtnMishori().setDisplayNone(true);
    }
}
