/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601006;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiranChange;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsahoshuichiran.ShinsaHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 介護認定審査会委員報酬一覧表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
public abstract class ShinsaHoshuIchiranProcess extends BatchProcessBase<ShinsaHoshuIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID_GOKE = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran.IShinsaHoshuIchiranMapper.get合計額");
    protected static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE604001"));
    protected static final RString CSV_FILE_NAME = new RString("介護認定審査会委員報酬一覧表.csv");
    protected static final RString なし = new RString("なし");
    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");
    private ShinsaHoshuIchiranChange 審査報酬一覧EntityConvertor;
    protected ShinsaHoshuIchiranProcessParameter paramter;
    private List<ShinsaHoshuIchiranRelateEntity> 出席状況EntityList;
    private int 出席回数;
    private static final RString 長 = new RString("長");
    private static final RString 出 = new RString("出");
    private static final RString 副 = new RString("副");
    private static final RString 月 = new RString("月");
    protected static final int ZERO = 0;
    protected static final long ONE = 1;
    private static final int FOUR = 4;

    @Override
    protected void initialize() {
        審査報酬一覧EntityConvertor = new ShinsaHoshuIchiranChange();
    }
    
    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        IShinsaHoshuIchiranMapper mapper = getMapper(IShinsaHoshuIchiranMapper.class);
        出席状況EntityList = mapper.get出席状況(paramter.get審査会開催年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_GOKE, paramter.toMybitisParamter());
    }

    @Override
    protected void process(ShinsaHoshuIchiranRelateEntity 合計額Entity) {
        for (ShinsaHoshuIchiranRelateEntity 出席状況Entity : 出席状況EntityList) {
            if ((合計額Entity.get合議体番号() == 出席状況Entity.get合議体番号())
                    && 合計額Entity.get介護認定審査会委員コード().equals(出席状況Entity.get介護認定審査会委員コード())) {
                出席状況Entity.set審査会開催年月(get出席日(paramter.get審査会開催年月(), paramter.get帳票出力区分()));
                出席状況Entity.set報酬総額(合計額Entity.get報酬総額());
                出席状況Entity.setその他費用(合計額Entity.getその他費用());
                出席状況Entity.set税額控除(合計額Entity.get税額控除());
                出席状況Entity.set報酬合計(合計額Entity.get報酬合計());
                出席状況Entity.set総合計_報酬総額(合計額Entity.get総合計_報酬総額());
                出席状況Entity.set総合計_その他費用(合計額Entity.get総合計_その他費用());
                出席状況Entity.set総合計_税控除額(合計額Entity.get総合計_税控除額());
                出席状況Entity.set総合計_報酬合計(合計額Entity.get総合計_報酬合計());

                出席回数 = 0;
                this.count出席回数(出席状況Entity.get出席状況_1日());
                this.count出席回数(出席状況Entity.get出席状況_2日());
                this.count出席回数(出席状況Entity.get出席状況_3日());
                this.count出席回数(出席状況Entity.get出席状況_4日());
                this.count出席回数(出席状況Entity.get出席状況_5日());
                this.count出席回数(出席状況Entity.get出席状況_6日());
                this.count出席回数(出席状況Entity.get出席状況_7日());
                this.count出席回数(出席状況Entity.get出席状況_8日());
                this.count出席回数(出席状況Entity.get出席状況_9日());
                this.count出席回数(出席状況Entity.get出席状況_10日());
                this.count出席回数(出席状況Entity.get出席状況_11日());
                this.count出席回数(出席状況Entity.get出席状況_12日());
                this.count出席回数(出席状況Entity.get出席状況_13日());
                this.count出席回数(出席状況Entity.get出席状況_14日());
                this.count出席回数(出席状況Entity.get出席状況_15日());
                this.count出席回数(出席状況Entity.get出席状況_16日());
                this.count出席回数(出席状況Entity.get出席状況_17日());
                this.count出席回数(出席状況Entity.get出席状況_18日());
                this.count出席回数(出席状況Entity.get出席状況_19日());
                this.count出席回数(出席状況Entity.get出席状況_20日());
                this.count出席回数(出席状況Entity.get出席状況_21日());
                this.count出席回数(出席状況Entity.get出席状況_22日());
                this.count出席回数(出席状況Entity.get出席状況_23日());
                this.count出席回数(出席状況Entity.get出席状況_24日());
                this.count出席回数(出席状況Entity.get出席状況_25日());
                this.count出席回数(出席状況Entity.get出席状況_26日());
                this.count出席回数(出席状況Entity.get出席状況_27日());
                this.count出席回数(出席状況Entity.get出席状況_28日());
                this.count出席回数(出席状況Entity.get出席状況_29日());
                this.count出席回数(出席状況Entity.get出席状況_30日());
                this.count出席回数(出席状況Entity.get出席状況_31日());
                出席状況Entity.set出席回数(出席回数);

                ShinsaHoshuIchiranEntity 審査報酬一覧Entity = 
                        審査報酬一覧EntityConvertor.createData(出席状況Entity, paramter.get帳票出力区分());
                output(審査報酬一覧Entity);
            }
        }
    }
    
    protected abstract void output(ShinsaHoshuIchiranEntity 審査報酬一覧Entity);

    private void count出席回数(RString 出席状況) {
        if (ShinsaHoshuIchiranProcess.長.equals(出席状況) 
                || ShinsaHoshuIchiranProcess.副.equals(出席状況) 
                || ShinsaHoshuIchiranProcess.出.equals(出席状況)) {
            出席回数++;
        }
    }

    protected static RString getFormatted年月(RString 年月RString) {
        if (RString.isNullOrEmpty(年月RString)) {
            return RString.EMPTY;
        }
        return (new RYearMonth(年月RString)).wareki().toDateString();
    }

    private static RString get出席日(RString 年月RString, RString 帳票出力区分) {
        if (RString.isNullOrEmpty(年月RString)) {
            return RString.EMPTY;
        }
        
        if (CSVを出力する.equals(帳票出力区分)) {
            return getFormatted年月(年月RString);
        }
        
        if (一覧表を発行する.equals(帳票出力区分)) {
            RStringBuilder 出席日 = new RStringBuilder();
            出席日.append(年月RString.substring(FOUR));
            出席日.append(月);
            return 出席日.toRString();
        }
        
        return RString.EMPTY;
    }
}
