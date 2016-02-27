/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告統計データEntiyのBusinessクラスです。
 *
 */
public class JigyoHokokuNenpoResult {

    private final DbT7021JigyoHokokuTokeiDataEntity entity;

    /**
     * 事業報告統計データEntiy作成処理
     *
     * @param entity 事業報告統計データテーブルのエンティティ
     */
    public JigyoHokokuNenpoResult(DbT7021JigyoHokokuTokeiDataEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業報告統計データ情報"));
        this.entity = entity;
    }

    /**
     * 報告年を取得する。
     *
     * @return 報告年
     */
    public FlexibleYear get報告年() {
        return entity.getHokokuYSeireki();
    }

    /**
     * 報告月を取得する。
     *
     * @return 報告月
     */
    public RString get報告月() {
        return entity.getHokokuM();
    }

    /**
     * 集計対象年を取得する。
     *
     * @return 集計対象年
     */
    public FlexibleYear get集計対象年() {
        return entity.getShukeiTaishoYSeireki();
    }

    /**
     * 集計対象月を取得する。
     *
     * @return 集計対象月
     */
    public RString get集計対象月() {
        return entity.getShukeiTaishoM();
    }

    /**
     * 統計対象区分を取得する。
     *
     * @return 統計対象区分
     */
    public RString get統計対象区分() {
        return entity.getToukeiTaishoKubun();
    }

    /**
     * 市町村コードを取得する。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 表番号を取得する。
     *
     * @return 表番号
     */
    public Code get表番号() {
        return entity.getHyoNo();
    }

    /**
     * 集計番号を取得する。
     *
     * @return 集計番号
     */
    public Code get集計番号() {
        return entity.getShukeiNo();
    }

    /**
     * 集計単位を取得する。
     *
     * @return 集計単位
     */
    public Code get集計単位() {
        return entity.getShukeiTani();
    }

    /**
     * 縦番号を取得する。
     *
     * @return 縦番号
     */
    public Decimal get縦番号() {
        return entity.getTateNo();
    }

    /**
     * 横番号を取得する。
     *
     * @return 横番号
     */
    public Decimal get横番号() {
        return entity.getYokoNo();
    }

    /**
     * 集計結果値を取得する。
     *
     * @return 集計結果値
     */
    public Decimal get集計結果値() {
        return entity.getShukeiKekkaAtai();
    }

    /**
     * 集計項目名称を取得する。
     *
     * @return 集計項目名称
     */
    public RString get集計項目名称() {
        return null;
    }

    /**
     * 縦項目コードを取得する。
     *
     * @return 縦項目コード
     */
    public Code get縦項目コード() {
        return entity.getTateKomokuCode();
    }

    /**
     * 横項目コードを取得する。
     *
     * @return 横項目コード
     */
    public Code get横項目コード() {
        return entity.getYokoKomokuCode();
    }
}
