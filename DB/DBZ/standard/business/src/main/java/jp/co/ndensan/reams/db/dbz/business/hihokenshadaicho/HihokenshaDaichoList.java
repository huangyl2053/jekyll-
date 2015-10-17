/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者台帳のListを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoList implements Iterable<HihokenshaDaicho> {

    private final IItemList<HihokenshaDaicho> daichoList;

    /**
     * コンストラクタです。外部から受け取った被保険者台帳Listを、資格取得日の降順でメンバに登録します。
     *
     * @param daichoList 被保険者台帳List
     */
    public HihokenshaDaichoList(IItemList<HihokenshaDaicho> daichoList) {
        requireNonNull(daichoList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("引数のList", getClass().getSimpleName()));
//        this.daichoList = daichoList.sorted(HihokenshaDaichoModelComparators.orderBy処理日時.desc());
        this.daichoList = daichoList.sorted(null);
    }

    /**
     * 被保険者台帳Listから、資格を取得してから喪失するまでの、1期間分の履歴を抽出します。
     *
     * @param 資格取得日 資格取得日
     * @return 1期間分の被保険者台帳List
     */
    public IItemList<HihokenshaDaicho> toOneSeasonList(FlexibleDate 資格取得日) {
        List<HihokenshaDaicho> onSeasonList = new ArrayList<>();
        for (HihokenshaDaicho daicho : daichoList) {
            if (daicho.get資格取得年月日().equals(資格取得日)) {
                onSeasonList.add(daicho);
            }
        }
        return ItemList.of(onSeasonList);
    }

    /**
     * 被保険者台帳Listから、資格得喪情報の表現に必要な要素を抽出して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaicho> to資格得喪List() {
        List<HihokenshaDaicho> list = new ArrayList<>();
        //TODO #52997
        //資格得喪を表現するためには、被保険者台帳から、
        //  a, 同じ取得日を持つ情報の内、最新のデータ
        //を抽出する必要がある。
        //必要な被保険者台帳情報を、以下の手順で取得する。
        //
        //1, 被保険者台帳の取得日を格納する変数shutokuDateを用意（初期値 = null)。
        //2, 被保険者台帳Listの各要素daichoに対して以下の処理を繰り返し実行し、対象の情報を抽出する。
        //  2-1, 次の判定を行う。
        //      2-1-1, !daicho.get取得日().equals(shutokuDate)
        //  2-2, 2-1の判定結果がtrueの場合、以下の処理を実行する。
        //      2-2-1, daichoList.add(daicho)
        //      2-2-2, shutokuDate = daicho.get取得日()
        //3, 抽出した結果を戻り値として返す。
        return ItemList.of(list);
    }

    /**
     * 被保険者台帳Listから、住所地特例情報を表現するために必要な要素を抽出して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaicho> to住所地特例List() {
        List<HihokenshaDaicho> list = new ArrayList<>();
        FlexibleDate tekiyoDate = null;
        for (HihokenshaDaicho daicho : daichoList) {
            if (!daicho.get解除年月日().isEmpty()) {
                list.add(daicho);
                continue;
            }

            if (daicho.get適用年月日().isEmpty()) {
                continue;
            }

            if (!daicho.get適用年月日().equals(tekiyoDate)) {
                list.add(daicho);
                tekiyoDate = daicho.get適用年月日();
            }
        }
        return ItemList.of(list);
    }

    /**
     * 被保険者台帳Listから、資格関連異動情報の表現に必要な要素を抽出して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaicho> to資格関連異動List() {
        List<HihokenshaDaicho> list = new ArrayList<>();

        FlexibleDate henkoDate = null;
        for (HihokenshaDaicho daicho : daichoList) {

            if (daicho.get資格変更年月日().isEmpty()) {
                continue;
            }
            if (!daicho.get資格変更年月日().equals(henkoDate)) {
                list.add(daicho);
                henkoDate = daicho.get資格変更年月日();
            }

        }
        return ItemList.of(list);
    }

    @Override
    public Iterator<HihokenshaDaicho> iterator() {
        return daichoList.iterator();
    }

}
