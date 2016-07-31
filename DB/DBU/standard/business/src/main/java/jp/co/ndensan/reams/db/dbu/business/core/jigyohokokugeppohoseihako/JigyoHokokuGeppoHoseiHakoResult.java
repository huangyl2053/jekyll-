/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jigyohokokugeppohoseihako;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Setter;

/**
 * 事業報告集計一覧データResultクラスです。
 *
 * @reamsid_L DBU-1100-100 cuilin
 */
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoHoseiHakoResult {

    private final JigyoHokokuGeppoHoseiHakoEntity entity;
    private static final RString 業報告統計データ情報メッセージ = new RString("事業報告統計データ情報");

    /**
     * 事業報告集計一覧データEntity作成処理
     *
     * @param entity 事業報告集計一覧データのエンティティ
     */
    public JigyoHokokuGeppoHoseiHakoResult(JigyoHokokuGeppoHoseiHakoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(業報告統計データ情報メッセージ.toString()));
        this.entity = entity;
    }

    /**
     * getJigyoHokokuGeppoHoseiHakoEntity
     *
     * @return JigyoHokokuGeppoHoseiHakoEntity
     */
    public JigyoHokokuGeppoHoseiHakoEntity getJigyoHokokuGeppoHoseiHakoEntity() {
        return entity;
    }

    /**
     * 報告年を取得する。
     *
     * @return 報告年
     */
    public FlexibleYear get報告年() {
        return entity.getEntity().getHokokuYSeireki();
    }

    /**
     * 報告月を取得する。
     *
     * @return 報告月
     */
    public RString get報告月() {
        return entity.getEntity().getHokokuM();
    }

    /**
     * 集計対象年を取得する。
     *
     * @return 集計対象年
     */
    public FlexibleYear get集計対象年() {
        return entity.getEntity().getShukeiTaishoYSeireki();
    }

    /**
     * 集計対象月を取得する。
     *
     * @return 集計対象月
     */
    public RString get集計対象月() {
        return entity.getEntity().getShukeiTaishoM();
    }

    /**
     * 統計対象区分を取得する。
     *
     * @return 統計対象区分
     */
    public RString get統計対象区分() {
        return entity.getEntity().getToukeiTaishoKubun();
    }

    /**
     * 市町村コードを取得する。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getEntity().getShichosonCode();
    }

    /**
     * 表番号を取得する。
     *
     * @return 表番号
     */
    public Code get表番号() {
        return entity.getEntity().getHyoNo();
    }

    /**
     * 集計番号を取得する。
     *
     * @return 集計番号
     */
    public Code get集計番号() {
        return entity.getEntity().getShukeiNo();
    }

    /**
     * 集計単位を取得する。
     *
     * @return 集計単位
     */
    public Code get集計単位() {
        return entity.getEntity().getShukeiTani();
    }

    /**
     * 縦番号を取得する。
     *
     * @return 縦番号
     */
    public Decimal get縦番号() {
        return entity.getEntity().getTateNo();
    }

    /**
     * 横番号を取得する。
     *
     * @return 横番号
     */
    public Decimal get横番号() {
        return entity.getEntity().getYokoNo();
    }

    /**
     * 集計結果値を取得する。
     *
     * @return 集計結果値
     */
    public Decimal get集計結果値() {
        return entity.getEntity().getShukeiKekkaAtai();
    }

    /**
     * 集計項目名称を取得する。
     *
     * @return 集計項目名称
     */
    public RString get集計項目名称() {
        return entity.getEntity().getShukeiKomokuMeisho();
    }

    /**
     * 縦項目コードを取得する。
     *
     * @return 縦項目コード
     */
    public Code get縦項目コード() {
        return entity.getEntity().getTateKomokuCode();
    }

    /**
     * 横項目コードを取得する。
     *
     * @return 横項目コード
     */
    public Code get横項目コード() {
        return entity.getEntity().getYokoKomokuCode();
    }

    /**
     * 様式コードを取得する。
     *
     * @return 様式コード
     */
    public RString get様式コード() {
        return entity.getYoshiCode();
    }

}
