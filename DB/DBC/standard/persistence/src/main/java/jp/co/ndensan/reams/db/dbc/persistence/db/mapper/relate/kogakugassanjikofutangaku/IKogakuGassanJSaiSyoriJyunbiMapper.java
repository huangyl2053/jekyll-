/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanjikofutangaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120130.KogakuGassanJSaiSyoriJyunbiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoDateEntity;

/**
 * 高額合算自己負担額証明書情報取込のmapperです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public interface IKogakuGassanJSaiSyoriJyunbiMapper {

    /**
     * 高額合算自己負担額の再処理準備です。
     *
     * @param parameter KogakuGassanJikofutangakuDoMasterTorokuParameter
     */
    void do再処理準備(KogakuGassanJikofutangakuDoMasterTorokuParameter parameter);

    /**
     * 高額合算自己負担額のマスタ更新です。
     *
     * @return List<KogakuGassanJSaiSyoriJyunbiEntity>
     */
    List<KogakuGassanJSaiSyoriJyunbiEntity> select高額合算自己負担額一時と明細データ();

    /**
     * 高額合算自己負担額のマスタ更新です。
     *
     * @return List<DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity>
     */
    List<DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity> select連番();

    /**
     * 高額合算自己負担額のget帳票出力対象データです。
     *
     * @return List<KogakuGassanJikofutangakuShomeishoDateEntity>
     */
    List<KogakuGassanJikofutangakuShomeishoDateEntity> get帳票出力対象データ();
}
