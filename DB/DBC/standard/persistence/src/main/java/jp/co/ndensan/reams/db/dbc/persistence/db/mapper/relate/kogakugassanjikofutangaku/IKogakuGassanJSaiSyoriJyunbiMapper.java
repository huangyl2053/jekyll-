/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanjikofutangaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanjsaisyorijyunbi.IKogakuGassanJSaiSyoriJyunbiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;

/**
 * 高額合算自己負担額証明書情報取込のmapperです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public interface IKogakuGassanJSaiSyoriJyunbiMapper {

    /**
     * 高額合算自己負担額の再処理準備です。
     *
     * @param parameter IKogakuGassanJSaiSyoriJyunbiMapperParameter
     */
    void do再処理準備(IKogakuGassanJSaiSyoriJyunbiMapperParameter parameter);

    /**
     * 高額合算自己負担額のマスタ更新です。
     *
     * @param parameter IKogakuGassanJSaiSyoriJyunbiMapperParameter
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    List<DbT3070KogakuGassanJikoFutanGakuEntity> doBeforeマスタ更新(IKogakuGassanJSaiSyoriJyunbiMapperParameter parameter);

    /**
     * 高額合算自己負担額のマスタ更新です。
     *
     * @param parameter IKogakuGassanJSaiSyoriJyunbiMapperParameter
     */
    void doマスタ更新(IKogakuGassanJSaiSyoriJyunbiMapperParameter parameter);

    /**
     * 高額合算自己負担額のselect連番です。
     *
     * @return DbWT37H1KogakuGassanaJikofutangakuTempEntity
     */
    List<DbWT37H1KogakuGassanaJikofutangakuTempEntity> select連番();
}
