/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc130010.UpdShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込(処理管理日付マスタ更新)
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private UpdShoriDateKanriProcessParameter processParameter;
    private static final RString 処理名 = new RString("後期高齢者情報取り込み");
    private static final RString 零零 = new RString("00");

    @Override
    protected void process() {
        for (RString 市町村識別ID : processParameter.get処理対象市町村()) {
            UpdShoriDateKanriMybatisParameter mybatisParameter = new UpdShoriDateKanriMybatisParameter();
            mybatisParameter.set処理名(処理名);
            mybatisParameter.set処理枝番(零零.concat(市町村識別ID));
            RDateTime 処理日時 = RDateTime.parse(processParameter.get処理日時().toString());
            mybatisParameter.set基準年月日(処理日時.getDate().toDateString());
            mybatisParameter.set基準日時(new YMDHMS(処理日時));
            mybatisParameter.set対象開始年月日(new RString(FlexibleDate.getNowDate().toString()));
            mybatisParameter.set対象開始日時(YMDHMS.now());
            mybatisParameter.set処理日時(処理日時);
            getMapper(IKokuhoShikakuIdoInMapper.class).up処理管理日付マスタ(mybatisParameter);
        }
    }
}
