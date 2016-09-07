/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.kyufugakugengakukanrilist;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付額減額管理リスト作成用のパラメータクラスです。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugakuGengakuKanriListProcessParameter implements IBatchProcessParameter {

    private RDate 基準日;
    private RString 対象区分;
    private boolean 通知書未発行者抽出;
    private boolean 減額適用中者抽出;
    private RDate 減額適用中者抽出基準日;
    private boolean 減額終了日抽出;
    private RDate 減額終了日範囲From;
    private RDate 減額終了日範囲To;
    private boolean 保険料完納者出力;
    private RString 改頁出力順ID;
    private RString 帳票ID;

    /**
     * コンストラクタ作成です。
     *
     * @param kijundate 基準日
     * @param taishokibun 対象区分
     * @param tsuchishomihakko 通知書未発行者抽出
     * @param gengakutekiyochusha 減額適用中者抽出
     * @param gengakutekiyochushakijundate 減額適用中者抽出基準日
     * @param gengakushuryodate 減額終了日抽出
     * @param gengakushuryorangefrom 減額終了日範囲From
     * @param gengakushuryorangeto 減額終了日範囲To
     * @param outputshokenryokannosha 保険料完納者出力
     * @param shuturokuJyunID 改頁出力順ID
     * @param tyouhyoID 帳票ID
     */
    public KyufugakuGengakuKanriListProcessParameter(RDate kijundate,
            RString taishokibun,
            boolean tsuchishomihakko,
            boolean gengakutekiyochusha,
            RDate gengakutekiyochushakijundate,
            boolean gengakushuryodate,
            RDate gengakushuryorangefrom,
            RDate gengakushuryorangeto,
            boolean outputshokenryokannosha,
            RString shuturokuJyunID,
            RString tyouhyoID) {
        this.基準日 = kijundate;
        this.対象区分 = taishokibun;
        this.通知書未発行者抽出 = tsuchishomihakko;
        this.減額適用中者抽出 = gengakutekiyochusha;
        this.減額適用中者抽出基準日 = gengakutekiyochushakijundate;
        this.減額終了日抽出 = gengakushuryodate;
        this.減額終了日範囲From = gengakushuryorangefrom;
        this.減額終了日範囲To = gengakushuryorangeto;
        this.保険料完納者出力 = outputshokenryokannosha;
        this.改頁出力順ID = shuturokuJyunID;
        this.帳票ID = tyouhyoID;
    }

}
