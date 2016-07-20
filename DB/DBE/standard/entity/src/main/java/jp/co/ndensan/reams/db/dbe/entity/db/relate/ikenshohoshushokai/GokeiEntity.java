/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成報酬の合計データの帳票のパラメータクラスです。
 *
 * @reamsid_L DBE-1930-030 chenxiangyu
 */
@Getter
@Setter
public class GokeiEntity {

    private int 在新;
    private int 在継;
    private int 施新;
    private int 施継;
    private RString 作成料;
    private RString 診断検査費用;
    private RString 合計;
    private int 番号;

    /**
     * コンストラクタです。
     *
     * @param 在新 在新の合計データ
     * @param 在継 在継の合計データ
     * @param 施新 施新の合計データ
     * @param 施継 施継の合計データ
     * @param 作成料 作成料の合計データ
     * @param 診断検査費用 診断検査費用の合計データ
     * @param 合計 単項合計の合計データ
     * @param 番号 主治医意見書作成報酬帳票の一覧リストのNo
     */
    public GokeiEntity(int 在新,
            int 在継,
            int 施新,
            int 施継,
            RString 作成料,
            RString 診断検査費用,
            RString 合計,
            int 番号) {
        this.在新 = 在新;
        this.在継 = 在継;
        this.施新 = 施新;
        this.施継 = 施継;
        this.作成料 = 作成料;
        this.診断検査費用 = 診断検査費用;
        this.合計 = 合計;
        this.番号 = 番号;
    }

    /**
     * コンストラクタです。
     */
    public GokeiEntity() {
    }
}
