/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanjikofutangakushomeishoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0001HihokenshaEntity;

/**
 * 高額合算自己負担額確認情報（CSVファイル取込） DB操作です。
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
public interface IKogakuGassanJikofutangakuShomeishoMapper {

    /**
     * select高額合算自己負担額一時TBL件数。
     *
     * @param entity DbWT37H1KogakuGassanaJikofutangakuTempEntity
     * @return 高額合算自己負担額一時TBL件数
     */
    int select高額合算自己負担額一時TBL件数(DbWT37H1KogakuGassanaJikofutangakuTempEntity entity);

    List<DbWT37H1KogakuGassanaJikofutangakuTempEntity> select請求額通知書一時();

    List<DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity> select請求額通知書一();

    List<DbWT0001HihokenshaEntity> select請求額通知書時();
}
