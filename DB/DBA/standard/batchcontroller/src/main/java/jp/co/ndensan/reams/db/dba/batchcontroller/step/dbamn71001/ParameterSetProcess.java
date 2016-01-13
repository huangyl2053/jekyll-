/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.dbamn71001;

import jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001.ParameterSetProcessParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.IDbT7022ShoriDateKanriMapper;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ内で抽出条件の生成_バッチフ処理クラスです
 */
public class ParameterSetProcess extends SimpleBatchProcessBase {
    
   /**
     * OutputParameter用キー kaishiYMD
     */
    public static final RString KAISHI_YMD;
   /**
     * OutputParameter用キー shuryoYMD
     */
    public static final RString SHURYO_YMD;
    private ParameterSetProcessParameter patameter;
    private IDbT7022ShoriDateKanriMapper mapper;
    
        
    static {
        KAISHI_YMD = new RString("kaishiYMD");
        SHURYO_YMD = new RString("shuryoYMD");
    }
    private OutputParameter<FlexibleDate> kaishiYMD;
    private OutputParameter<FlexibleDate> shuryoYMD;
   
    
    @Override
    protected void beforeExecute() {
        kaishiYMD = new OutputParameter<>();
        shuryoYMD = new OutputParameter<>();
        mapper = getMapper(IDbT7022ShoriDateKanriMapper.class);
    }

    @Override
    protected void process() {
        
        FlexibleDate 開始日;
        FlexibleDate 終了日;
        
        DbT7022ShoriDateKanriEntity entity = mapper.get処理日付管理マスタByKey(patameter.toNinteiChosaTokusokujoMybatisParameter());
       
        if (entity != null) {
            開始日 = entity.getKijunYMD();
        } else {
            開始日 = new FlexibleDate(RDate.getNowDate().toDateString());
        }
        終了日 = new FlexibleDate(RDate.getNowDate().toDateString());
       
        if (開始日.isBefore(終了日)) {
            throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("開始日", "終了日"));
        }
        kaishiYMD.setValue(開始日);
        shuryoYMD.setValue(終了日);
    }
    
}
