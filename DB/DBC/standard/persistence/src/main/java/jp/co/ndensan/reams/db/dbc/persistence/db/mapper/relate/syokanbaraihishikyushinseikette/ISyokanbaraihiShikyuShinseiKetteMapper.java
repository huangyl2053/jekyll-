/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.ShafukukeigenServiceParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.ShafukukeigenServiceEntity;

/**
 * 社福軽減額サービス種類のマッパーインタフェースです。
 */
public interface ISyokanbaraihiShikyuShinseiKetteMapper {

    /**
     * 社福軽減額サービス種類情報取得
     *
     * @param parameter parameter
     * @return List<ShafukukeigenServiceEntity>
     */
    List<ShafukukeigenServiceEntity> get社福軽減額サービス種類(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求基本の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払請求基本(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求明細・住所地特例の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete住所地特例(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求明細の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払請求明細(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求特定診療費の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払請求特定診療費(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求特定診療費・特別療養費の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete特別療養費(ShafukukeigenServiceParameter parameter);

    /**
     * サービス計画費の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int deleteサービス計画200904(ShafukukeigenServiceParameter parameter);

    /**
     * サービス計画費の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int deleteサービス計画200604(ShafukukeigenServiceParameter parameter);

    /**
     * サービス計画費の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int deleteサービス計画200004(ShafukukeigenServiceParameter parameter);

    /**
     * 特定入所者費用の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete特定入所者介護サービス費用(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求社会福祉法人軽減額の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete社会福祉法人軽減額(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求所定疾患施設療養費等の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete所定疾患施設療養費等(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求緊急時施設療養の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払請求緊急時施設療養(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求集計の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払請求集計(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払請求食事費用のデータを削除する
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払請求食事費用(ShafukukeigenServiceParameter parameter);

    /**
     * 償還払支給申請の削除処理を行う
     *
     * @param parameter parameter
     * @return 削除件数
     */
    int delete償還払支給申請(ShafukukeigenServiceParameter parameter);
}
