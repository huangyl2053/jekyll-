/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 発行後異動者一覧情報 通知書発行後異動対象者一覧表を出力するために、帳票出力用のデータを格納する。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchiShoHakkogoIdoshaListJoho {

    private YMDHMS 通知書発行日時;
    private YMDHMS 最終計算処理日時;
    private RString 通知書名;
    private List<TsuchiShoHakkoGoIdosha> 異動者リスト;

    /**
     * コンストラクタです
     */
    public TsuchiShoHakkogoIdoshaListJoho() {

    }

    /**
     * コンストラクタです
     *
     * @param 通知書発行日時 YMDHMS
     * @param 最終計算処理日時 YMDHMS
     * @param 通知書名 RString
     * @param 異動者リスト List<TsuchiShoHakkoGoIdosha>
     */
    public TsuchiShoHakkogoIdoshaListJoho(YMDHMS 通知書発行日時, YMDHMS 最終計算処理日時, RString 通知書名,
            List<TsuchiShoHakkoGoIdosha> 異動者リスト) {
        this.通知書発行日時 = 通知書発行日時;
        this.最終計算処理日時 = 最終計算処理日時;
        this.通知書名 = 通知書名;
        this.異動者リスト = 異動者リスト;
    }

}
