/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.fukaerror;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReportCommon;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧のReportクラスです。
 */
public class FukaErrorListReportCommon implements IInternalReportCommon {

    private final DbT2010FukaErrorListEntity representativeEntity;

    public FukaErrorListReportCommon(DbT2010FukaErrorListEntity representativeEntity) {
        this.representativeEntity = representativeEntity;
    }

    @Override
    public SubGyomuCode getサブ業務コード() {
        return representativeEntity.getSubGyomuCode();
    }

    @Override
    public RString get内部帳票Id() {
        return representativeEntity.getInternalReportId();
    }

    @Override
    public RString get内部帳票名() {
        return representativeEntity.getInternalReportId();
    }

    @Override
    public RDateTime get内部帳票作成日時() {
        return representativeEntity.getInternalReportCreationDateTime();
    }

    @Override
    public RString getバッチId() {
        return representativeEntity.getBatchId();
    }

    @Override
    public RString getバッチ名() {
        return representativeEntity.getBatchId();
    }

    @Override
    public RDateTime getバッチ起動日時() {
        return representativeEntity.getBatchStartingDateTime();
    }
}
