/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist;

import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 事業報告集計一覧データを管理するビジネスです。
 *
 * @reamsid_L DBU-1130-050 wangjie2
 */
public class KaigoHokenJigyoHokokuNenpo {

    private final KaigoHokenJigyoHokokuNenpoEntity 事業報告集計一覧データ;

    /**
     * コンストラクタです。<br/>
     *
     * @param 事業報告集計一覧データ 事業報告集計一覧データ
     * @link KaigoHokenJigyoHokokuNenpoEntity}より{@link KaigoHokenJigyoHokokuNenpo}を生成します。
     *
     */
    public KaigoHokenJigyoHokokuNenpo(KaigoHokenJigyoHokokuNenpoEntity 事業報告集計一覧データ) {
        this.事業報告集計一覧データ = requireNonNull(事業報告集計一覧データ,
                UrSystemErrorMessages.値がnull.getReplacedMessage("事業報告集計一覧データのエンティティ"));
    }

    /**
     * コンストラクタです。<br/>
     *
     */
    public KaigoHokenJigyoHokokuNenpo() {
        this.事業報告集計一覧データ = new KaigoHokenJigyoHokokuNenpoEntity(FlexibleYear.EMPTY, RString.EMPTY, FlexibleYear.EMPTY, RString.EMPTY,
                RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY, Code.EMPTY, RString.EMPTY, Code.EMPTY, Code.EMPTY,
                new HashMap<RString, Decimal>());
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 集計対象月 集計対象月
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 集計番号 集計番号
     * @param 表番号 表番号
     * @param 集計単位 集計単位
     * @param 集計項目名称 集計項目名称
     * @param 縦項目コード 縦項目コード
     * @param 横項目コード 横項目コード
     * @param 詳細データエリア 詳細データエリア
     */
    public KaigoHokenJigyoHokokuNenpo(FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年,
            RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号,
            Code 集計単位, RString 集計項目名称, Code 縦項目コード, Code 横項目コード, Map<RString, Decimal> 詳細データエリア) {
        this.事業報告集計一覧データ = new KaigoHokenJigyoHokokuNenpoEntity(報告年, 報告月, 集計対象年, 集計対象月,
                統計対象区分, 市町村コード, 表番号, 集計番号, 集計単位, 集計項目名称, 縦項目コード, 横項目コード, 詳細データエリア);
    }

    /**
     * 詳細データエリアします。
     *
     * @return 詳細データエリア
     */
    public Map<RString, Decimal> get詳細データエリア() {
        return 事業報告集計一覧データ.get詳細データエリア();
    }

    /**
     * 報告年を返します。
     *
     * @return 報告年
     */
    public FlexibleYear get報告年() {
        return 事業報告集計一覧データ.get報告年();
    }

    /**
     * 報告年を返します。
     *
     * @param 報告年 報告年
     */
    public void set報告年(FlexibleYear 報告年) {
        事業報告集計一覧データ.set報告年(報告年);
    }

    /**
     * 集計対象年します。
     *
     * @return 集計対象年
     */
    public FlexibleYear get集計対象年() {
        return 事業報告集計一覧データ.get集計対象年();
    }

    /**
     * 集計対象年します。
     *
     * @param 集計対象年 集計対象年
     */
    public void set集計対象年(FlexibleYear 集計対象年) {
        事業報告集計一覧データ.set集計対象年(集計対象年);
    }

    /**
     * 報告月します。
     *
     * @return 報告月
     */
    public RString get報告月() {
        return 事業報告集計一覧データ.get報告月();
    }

    /**
     * 報告月します。
     *
     * @param 報告月 報告月
     */
    public void set報告月(RString 報告月) {
        事業報告集計一覧データ.set報告月(報告月);
    }

    /**
     * 統計対象区分します。
     *
     * @return 統計対象区分
     */
    public RString get統計対象区分() {
        return 事業報告集計一覧データ.get統計対象区分();
    }

    /**
     * 統計対象区分します。
     *
     * @param 統計対象区分 統計対象区分
     */
    public void set統計対象区分(RString 統計対象区分) {
        事業報告集計一覧データ.set統計対象区分(統計対象区分);
    }

    /**
     * 集計対象月します。
     *
     * @return 集計対象月
     */
    public RString get集計対象月() {
        return 事業報告集計一覧データ.get集計対象月();
    }

    /**
     * 集計対象月します。
     *
     * @param 集計対象月 集計対象月
     */
    public void set集計対象月(RString 集計対象月) {
        事業報告集計一覧データ.set集計対象月(集計対象月);
    }

    /**
     * 集計項目名称します。
     *
     * @return 集計項目名称
     */
    public RString get集計項目名称() {
        return 事業報告集計一覧データ.get集計項目名称();
    }

    /**
     * 市町村コードします。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 事業報告集計一覧データ.get市町村コード();
    }

    /**
     * 市町村コードします。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        事業報告集計一覧データ.set市町村コード(市町村コード);
    }

    /**
     * 表番号します。
     *
     * @return 表番号
     */
    public Code get表番号() {
        return 事業報告集計一覧データ.get表番号();
    }

    /**
     * 表番号します。
     *
     * @param 表番号 表番号
     */
    public void set表番号(Code 表番号) {
        事業報告集計一覧データ.set表番号(表番号);
    }

    /**
     * 集計単位します。
     *
     * @return 集計単位
     */
    public Code get集計単位() {
        return 事業報告集計一覧データ.get集計単位();
    }

    /**
     * 集計単位します。
     *
     * @param 集計単位 集計単位
     */
    public void set集計単位(Code 集計単位) {
        事業報告集計一覧データ.set集計単位(集計単位);
    }

    /**
     * 集計番号します。
     *
     * @return 集計番号
     */
    public Code get集計番号() {
        return 事業報告集計一覧データ.get集計番号();
    }

    /**
     * 集計番号します。
     *
     * @param 集計番号 集計番号
     */
    public void set集計番号(Code 集計番号) {
        事業報告集計一覧データ.set集計番号(集計番号);
    }

    /**
     * 横項目コードします。
     *
     * @return 横項目コード
     */
    public Code get横項目コード() {
        return 事業報告集計一覧データ.get横項目コード();
    }

    /**
     * 横項目コードします。
     *
     * @param 横項目コード 横項目コード
     */
    public void set横項目コード(Code 横項目コード) {
        事業報告集計一覧データ.set横項目コード(横項目コード);
    }

    /**
     * 縦項目コードします。
     *
     * @return 縦項目コード
     */
    public Code get縦項目コード() {
        return 事業報告集計一覧データ.get縦項目コード();
    }

    /**
     * 縦項目コードします。
     *
     * @param 縦項目コード 縦項目コード
     */
    public void set縦項目コード(Code 縦項目コード) {
        事業報告集計一覧データ.set縦項目コード(縦項目コード);
    }

}
