/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.tokuchotenbikiteishichoshuhohokoshin;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.dbx001001.TokuchoTenbikiTeishiMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin.ChoshuhohokoshinEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin.TokuchoTenbikiTeishiEntity;

/**
 * ITokuchoTenbikiTeishiChoshuhohokoshinMapperのインターフェースクラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
public interface ITokuchoTenbikiTeishiChoshuhohokoshinMapper {

    /**
     * getHihokenshaNosのメソドです。
     *
     * @param param TokuchoTenbikiTeishiMyBatisParameter
     * @return List<TokuchoTenbikiTeishiEntity>
     *
     */
    List<TokuchoTenbikiTeishiEntity> getHihokenshaNos(TokuchoTenbikiTeishiMyBatisParameter param);

    /**
     * getChoshoHohosのメソドです。
     *
     * @param param TokuchoTenbikiTeishiMyBatisParameter
     * @return List<ChoshuhohokoshinEntity>
     *
     */
    List<ChoshuhohokoshinEntity> getChoshoHohos(TokuchoTenbikiTeishiMyBatisParameter param);
}
