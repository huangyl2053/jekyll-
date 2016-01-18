/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 境界層該当者台帳管理のマッパーインタフェースです。
 */
public interface IKyokaisoGaitoshaMapper {

    /**
     * 境界層該当者一覧情報を取得します。
     *
     * @param parameter 境界層該当者一覧情報パラメータ
     * @return List<KyokaisoGaitoshaRelateEntity> 境界層該当者一覧情報リスト
     */
    List<KyokaisoGaitoshaJohoRelateEntity> select一覧情報(KyokaisoGaitoshaParameter parameter);

    /**
     * 最新履歴番号を取得します。
     *
     * @param parameter 最新履歴番号取得パラメータ
     * @return Decimal 最新履歴番号
     */
    Decimal selcet最新履歴番号(KyokaisoGaitoshaParameter parameter);

    /**
     * 最新リンク番号を取得します。
     *
     * @param parameter 最新リンク番号取得パラメータ
     * @return Decimal 最新リンク番号
     */
    Decimal selcet最新リンク番号(KyokaisoGaitoshaParameter parameter);

    /**
     * 検索条件より、適当な条件を連結して、境界層該当者情報を検索する。
     *
     * @param 検索条件 境界層該当者一覧情報パラメータ
     * @return DbT1006KyokaisoGaitoshaEntityの{@code list}
     */
    List<KyokaisoGaitoRelateEntity> select境界層該当者(KyokaisoGaitoshaParameter 検索条件);
}
