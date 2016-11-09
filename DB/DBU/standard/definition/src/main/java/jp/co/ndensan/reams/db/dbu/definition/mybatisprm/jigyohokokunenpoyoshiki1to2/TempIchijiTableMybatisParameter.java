/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import lombok.Getter;

/**
 * 事業状況報告年報　様式１・２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class TempIchijiTableMybatisParameter {

    private final LasdecCode 市町村コード;
    private final LasdecCode 旧市町村コード;
    private final int 所得段階index;

    private final boolean is所得段階;
    private final boolean is市町村コード;
    private final boolean is旧市町村コード;

    /**
     * コンストラクタです。
     */
    private TempIchijiTableMybatisParameter(
            LasdecCode 市町村コード, LasdecCode 旧市町村コード, int 所得段階index,
            boolean is市町村コード, boolean is旧市町村コード, boolean is所得段階) {
        this.市町村コード = 市町村コード;
        this.旧市町村コード = 旧市町村コード;
        this.所得段階index = 所得段階index;
        this.is所得段階 = is所得段階;
        this.is市町村コード = is市町村コード;
        this.is旧市町村コード = is旧市町村コード;
    }

    /**
     * 一時テーブルのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @param is市町村コード is市町村コード
     * @param is旧市町村コード is旧市町村コード
     * @param is所得段階 is所得段階
     * @param 所得段階index 所得段階index
     * @return Yoshiki1To2ComMybatisParameter
     */
    public static TempIchijiTableMybatisParameter createTempIchijiTableParam(
            LasdecCode 市町村コード, LasdecCode 旧市町村コード, boolean is市町村コード,
            boolean is旧市町村コード, boolean is所得段階,
            int 所得段階index) {
        return new TempIchijiTableMybatisParameter(市町村コード, 旧市町村コード,
                所得段階index, is市町村コード,
                is旧市町村コード, is所得段階);

    }
}
