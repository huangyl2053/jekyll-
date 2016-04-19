/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.KibetsuChoshyuYuyoKikan;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプレイヤ１Editor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class ReiyaA4Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final RString 文書番号;
    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報;
    private final HyojiCodes 表示コード;
    private final RString 通知書定型文;
    private final List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List;
    private final List<RString> 随時リスト;
    private final int index;

    /**
     * コンストラクタです
     *
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 表示コード 表示コード
     * @param 通知書定型文 通知書定型文
     * @param 期別徴収猶予期間List 期別徴収猶予期間List
     * @param 随時リスト 随時リスト
     * @param index index
     */
    public ReiyaA4Editor(RString 文書番号, KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            HyojiCodes 表示コード, RString 通知書定型文, List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List,
            List<RString> 随時リスト, int index) {
        this.文書番号 = 文書番号;
        this.徴収猶予決定通知書情報 = 徴収猶予決定通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.表示コード = 表示コード;
        this.期別徴収猶予期間List = 期別徴収猶予期間List;
        this.随時リスト = 随時リスト;
        this.index = index;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        source.bunshoNo = 文書番号;
        source.choteiNendo = 徴収猶予決定通知書情報.get徴収猶予の情報().get調定年度();
        source.fukaNendo = 徴収猶予決定通知書情報.get徴収猶予の情報().get調定年度();
        source.ketteiKekka = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予状態区分();
        source.hyojicodeName1 = 表示コード.get表示コード名１();
        source.hyojicodeName2 = 表示コード.get表示コード名２();
        source.hyojicodeName3 = 表示コード.get表示コード名３();
        source.hyojicode1 = 表示コード.get表示コード１();
        source.hyojicode2 = 表示コード.get表示コード２();
        source.hyojicode3 = 表示コード.get表示コード３();
        source.tsuchishoNo = 徴収猶予決定通知書情報.get徴収猶予の情報().get通知書番号();
        source.setaiCode = 徴収猶予決定通知書情報.get徴収猶予の情報().get世帯コード();
        source.hihokenshaNo = 徴収猶予決定通知書情報.get徴収猶予の情報().get被保険者番号();
        source.shikibetsuCode = 徴収猶予決定通知書情報.get徴収猶予の情報().get識別コード();
        source.ketteiYMD = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予決定日();
        source.ketteiRiyu1 = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予種類();
        source.ketteiRiyu2 = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予取消事由();
        source.listKibetsu_1 = 期別徴収猶予期間List.get(index - 1).get特徴期();
        source.listKibetsu_2 = 期別徴収猶予期間List.get(index - 1).get特徴月();
        source.listKibetsu_3 = 期別徴収猶予期間List.get(index - 1).get特徴期別金額();
        source.listKibetsu_4 = 期別徴収猶予期間List.get(index - 1).get普徴期();
        source.listKibetsu_5 = 期別徴収猶予期間List.get(index - 1).get普徴月();
        source.listKibetsu_6 = 期別徴収猶予期間List.get(index - 1).get普徴期別金額();
        source.listKibetsu_7 = 期別徴収猶予期間List.get(index - 1).get徴収猶予期間();
        source.listZuiji_1 = 随時リスト.get(index - 1);
        source.bikoTitle = 通知書定型文;
        source.biko = 通知書定型文;
        return source;
    }

}
