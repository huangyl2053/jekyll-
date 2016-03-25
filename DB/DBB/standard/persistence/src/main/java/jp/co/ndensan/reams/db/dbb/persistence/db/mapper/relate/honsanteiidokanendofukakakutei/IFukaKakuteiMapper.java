/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendofukakakutei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofukakakutei.FukaKakuteiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidofukakakutei.KanendoIdoFukaKakuteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.chotei.UrT0706ChoteigakuUchiwakeEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.chotei.UrT0707ChoteiJokyoEntity;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.shuno.shunokanri.UrT0700ShunoKanriEntity;

/**
 * 本算定異動（過年度）賦課確定（削除込）用マッパーです
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
     * 対応行の納付額と納期限へ設定する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return UrT0705ChoteiKyotsuEntity
     */
    UrT0705ChoteiKyotsuEntity select納付額と納期限(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 収納管理マスタ（介護継承）のデータを取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<UrT0700ShunoKanriEntity> select収納管理マスタ(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 調定額内訳（介護継承）のデータを取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<UrT0706ChoteigakuUchiwakeEntity> select調定額内訳(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 調定共通（介護継承）のデータを取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<UrT0705ChoteiKyotsuEntity> select調定共通(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 調定状況（介護継承）のデータを取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<UrT0707ChoteiJokyoEntity> select調定状況(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 調定共通（介護継承）のデータを取得する。
     *
     * @param fukaKakuteiParameter FukaKakuteiParameter
     * @return list
     */
    List<UrT0705ChoteiKyotsuEntity> select調定共通ForUpdate(FukaKakuteiParameter fukaKakuteiParameter);

    /**
     * 調定額内訳（介護継承）のデータを削除する。
     *
     * @param parameter Map
     */
    void delete調定額内訳(Map<String, Object> parameter);

    /**
     * 調定状況（介護継承）のデータを削除する。
     *
     * @param parameter Map
     */
    void delete調定状況(Map<String, Object> parameter);

    /**
     * 収納管理マスタ（介護継承）のデータを削除する。
     *
     * @param parameter Map
     */
    void delete収納管理マスタ(Map<String, Object> parameter);
}
