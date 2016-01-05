/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaRelateEntity;
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
    List<KyokaisoGaitoshaRelateEntity> select一覧情報(KyokaisoGaitoshaParameter parameter);

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
}
