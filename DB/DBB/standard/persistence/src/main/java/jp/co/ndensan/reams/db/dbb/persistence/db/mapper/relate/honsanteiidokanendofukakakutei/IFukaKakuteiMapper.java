/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendofukakakutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofukakakutei.FukaKakuteiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidofukakakutei.KanendoIdoFukaKakuteiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 本算定異動（過年度）賦課確定（削除込）用マッパーです。
 *
 * @reamsid_L DBB-0680-020 wangkanglei
 */
public interface IFukaKakuteiMapper {

    /**
     * 更新後の賦課内容を取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<KanendoIdoFukaKakuteiEntity> select更新後の賦課内容(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 調定共通（介護継承）のデータを取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<UrT0705ChoteiKyotsuEntity> select調定共通ForUpdate(FukaKakuteiParameter fukaKakuteiParameter);
}
