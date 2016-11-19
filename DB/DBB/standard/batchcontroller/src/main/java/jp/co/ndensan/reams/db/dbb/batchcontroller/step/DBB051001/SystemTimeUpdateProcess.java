/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou.GenNendoHonsanteiIdou;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「処理日付管理テーブル更新」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class SystemTimeUpdateProcess extends SimpleBatchProcessBase {

    private GenNendoHonsanteiIdou business;
    private GennendoIdoFukaProcessParameter processParameter;
    private final RString 枝番0001 = new RString("0001");
    private final RString 枝番0004 = new RString("0004");
    private final RString 枝番0005 = new RString("0005");
    private final RString 枝番0006 = new RString("0006");
    private static final RString 依頼金額計算_0 = new RString("0");
    private static final RString 特徴開始月_12 = new RString("特徴開始月：12月（捕捉月：6月）");    
    private static final RString 特徴開始月_2 = new RString("特徴開始月：2月（捕捉月：8月）");
    private static final RString 特徴開始月_4 = new RString("特徴開始月：4月（捕捉月：10月）");
    private static final RString 待機_4 = new RString("特徴開始月：4月（捕捉月：6,8,10月）");

    @Override
    protected void beforeExecute() {
        business = GenNendoHonsanteiIdou.createInstance();
    }

    @Override
    protected void process() {
        RString 処理名 = new RString(ShoriName.依頼金額計算.toString());
        RString 処理枝番 = 枝番0001;
        RString 年度内連番 = 枝番0001;
        FlexibleYear 年度 = processParameter.get調定年度();
        YMDHMS システム日時 = new YMDHMS(processParameter.get調定日時());
        
        
        if(依頼金額計算_0.equals(processParameter.get特徴捕捉対象者の依頼金額計算())){
         business.insert処理日付管理(processParameter, システム日時, 処理枝番, 年度内連番);   
        }
        if (特徴開始月_12.equals(processParameter.get異動賦課で同時に計算する特徴捕捉分())) {
            business.update処理日付管理(処理名, 処理枝番, 年度, 枝番0004, システム日時);
        } else if (特徴開始月_2.equals(processParameter.get異動賦課で同時に計算する特徴捕捉分())) {
            business.update処理日付管理(処理名, 処理枝番, 年度, 枝番0005, システム日時);
        } else if (特徴開始月_4.equals(processParameter.get異動賦課で同時に計算する特徴捕捉分())
                ||待機_4.equals(processParameter.get異動賦課で同時に計算する特徴捕捉分())) {
            business.update処理日付管理(処理名, 処理枝番, 年度, 枝番0006, システム日時);
        }
    }
}
