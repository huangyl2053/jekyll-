/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.KyuShichosonShikaku;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GesshoGetsumatsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShinKyuHokenshaNoHenkanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.realservice.gappei._GappeiShichosonFinder;
import jp.co.ndensan.reams.db.dbz.realservice.gappei.IGappeiShichosonFinder;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 基準月時点の市町村情報を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KijunTsukiShichosonFinder {

    private final IGappeiShichosonFinder gappeiFinder;

    /**
     * コンストラクタです。
     */
    public KijunTsukiShichosonFinder() {
        gappeiFinder = new _GappeiShichosonFinder();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param gappeiFinder 合併市町村情報取得Finder
     */
    KijunTsukiShichosonFinder(IGappeiShichosonFinder gappeiFinder) {
        this.gappeiFinder = gappeiFinder;
    }

    /**
     * 対象となる被保険者の基準月時点での合併市町村情報を取得します。
     *
     * @param 被保険者情報List 被保険者情報
     * @param 基準年月 基準年月
     * @param 月初月末区分 月初月末区分
     * @return 合併市町村情報
     */
    public Optional<GappeiShichosonJohoModel> get基準月市町村情報(
            List<HihokenshaDaichoModel> 被保険者情報List, FlexibleYearMonth 基準年月, GesshoGetsumatsuKubun 月初月末区分) {

        KyuShichosonShikaku 旧市町村資格 = new KyuShichosonShikaku(被保険者情報List);
        Optional<HihokenshaDaichoModel> 被保険者台帳 = 旧市町村資格.get旧市町村被保険者情報By月初月末指定(基準年月, GesshoGetsumatsuKubun.指定無);
        if (!被保険者台帳.isPresent()) {
            return Optional.empty();
        }

        LasdecCode 市町村コード = 被保険者台帳.get().get市町村コード();
        Optional<GappeiShichosonJohoModel> check1 = gappeiFinder.get最新合併市町村情報(市町村コード);
        if (!check1.isPresent() || !check1.get().get合併情報().isPresent()) {
            return set新旧被保険者番号変換区分(gappeiFinder.get市町村情報(市町村コード), 基準年月);
        }

        FlexibleYearMonth 国保連開始年月 = check1.get().get合併情報().get().get国保連データ連携開始日().getYearMonth();
        if (国保連開始年月.isBeforeOrEquals(基準年月)) {
            return set新旧被保険者番号変換区分(apply月処理(check1, 月初月末区分), 基準年月);
        }

        LasdecCode 旧市町村コード = 被保険者台帳.get().get旧市町村コード();
        Optional<GappeiShichosonJohoModel> check3 = gappeiFinder.get最古合併市町村情報(旧市町村コード);
        国保連開始年月 = check3.get().get合併情報().get().get国保連データ連携開始日().getYearMonth();
        if (基準年月.isBefore(国保連開始年月)) {
            return set新旧被保険者番号変換区分(apply月処理(check3, 月初月末区分), 基準年月);
        }

        IItemList<GappeiShichosonJohoModel> check4List = gappeiFinder.get合併市町村情報(旧市町村コード);
        for (GappeiShichosonJohoModel check4 : check4List) {
            国保連開始年月 = check4.get合併情報().get().get国保連データ連携開始日().getYearMonth();
            if (基準年月.isBefore(国保連開始年月)) {
                return set新旧被保険者番号変換区分(apply月処理(Optional.of(check4), 月初月末区分), 基準年月);
            }
        }

        return Optional.empty();
    }

    /**
     * 対象となる被保険者の基準月時点での合併市町村情報を取得します。
     *
     * @param 基準年月 基準年月
     * @param 保険者番号 保険者番号
     * @return 合併市町村情報
     * @throws IllegalArgumentException 基準年月より後に合併した保険者番号を指定した場合
     */
    public Optional<GappeiShichosonJohoModel> get基準月市町村情報(
            FlexibleYearMonth 基準年月, ShoKisaiHokenshaNo 保険者番号) throws IllegalArgumentException {

        if (gappeiFinder.get最新合併市町村情報(保険者番号, 基準年月).isPresent()) {
            Optional<GappeiShichosonJohoModel> check2 = gappeiFinder.get直近合併市町村情報(保険者番号, 基準年月);
            if (check2.isPresent()) {
                return set新旧被保険者番号変換区分(check2, 基準年月);
            } else {
                return set新旧被保険者番号変換区分(gappeiFinder.get市町村情報(保険者番号), 基準年月);
            }
        } else {
            Optional<GappeiShichosonJohoModel> check3 = gappeiFinder.get直近合併市町村情報(保険者番号);
            if (check3.isPresent()) {
                return set新旧被保険者番号変換区分(check3, 基準年月);
            } else {
                Optional<GappeiShichosonJohoModel> check4 = gappeiFinder.get最新合併市町村情報(保険者番号);
                if (check4.isPresent()) {
                    throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("保険者番号").evaluate());
                } else {
                    return set新旧被保険者番号変換区分(gappeiFinder.get市町村情報(保険者番号), 基準年月);
                }
            }
        }

    }

    private Optional<GappeiShichosonJohoModel> apply月処理(Optional<GappeiShichosonJohoModel> 処理前, GesshoGetsumatsuKubun 月初月末区分) {
        GappeiShichosonJohoModel 処理後 = new GappeiShichosonJohoModel(
                処理前.get().get合併情報(),
                処理前.get().get保険者構成区分(),
                apply月処理Of合併市町村(処理前.get().get単一市町村情報(), 月初月末区分),
                apply月処理Of構成市町村(処理前.get().get広域市町村情報(), 月初月末区分));
        return Optional.of(処理後);
    }

    private IItemList<IGappeiShichoson> apply月処理Of合併市町村(IItemList<IGappeiShichoson> 処理前List, GesshoGetsumatsuKubun 月区分) {
        List<IGappeiShichoson> 処理後List = new ArrayList<>();
        if (!処理前List.isEmpty()) {
            List<IGappeiShichoson> list = 処理前List.toList();
            switch (月区分) {
                case 指定無:
                    処理後List = list;
                    break;
                case 月初:
                    処理後List.add(list.get(0));
                    break;
                case 月末:
                    処理後List.add(list.get(list.size() - 1));
                    break;
                default:
                    break;
            }
        }
        return ItemList.of(処理後List);
    }

    private IItemList<IKoikiKoseiShichoson> apply月処理Of構成市町村(IItemList<IKoikiKoseiShichoson> 処理前List, GesshoGetsumatsuKubun 月区分) {
        List<IKoikiKoseiShichoson> 処理後List = new ArrayList<>();
        if (!処理前List.isEmpty()) {
            List<IKoikiKoseiShichoson> list = 処理前List.toList();
            switch (月区分) {
                case 指定無:
                    処理後List = list;
                    break;
                case 月初:
                    処理後List.add(list.get(0));
                    break;
                case 月末:
                    処理後List.add(list.get(list.size() - 1));
                    break;
                default:
                    break;
            }
        }
        return ItemList.of(処理後List);
    }

    private Optional<GappeiShichosonJohoModel> set新旧被保険者番号変換区分(Optional<GappeiShichosonJohoModel> 処理前, FlexibleYearMonth 基準年月) {
        if (処理前.get().get保険者構成区分() != HokenshaKosei.広域市町村) {
            return 処理前;
        }
        Optional<GappeiShichosonJohoModel> 合併市町村情報 = gappeiFinder.get最古市町村情報(処理前.get().get広域市町村情報().toList().get(0).get市町村コード());
        ShinKyuHokenshaNoHenkanKubun 新旧被保険者番号変換区分 = ShinKyuHokenshaNoHenkanKubun.UNKNOWN;
        if (!合併市町村情報.get().get広域市町村情報().isEmpty()) {
            if (合併市町村情報.get().get広域市町村情報().toList().get(0).get加入日().getYearMonth().isBeforeOrEquals(基準年月)) {
                新旧被保険者番号変換区分 = ShinKyuHokenshaNoHenkanKubun.変換不要;
            } else {
                新旧被保険者番号変換区分 = ShinKyuHokenshaNoHenkanKubun.変換必要;
            }
        }
        GappeiShichosonJohoModel 処理後 = new GappeiShichosonJohoModel(
                処理前.get().get合併情報(), 処理前.get().get保険者構成区分(), 処理前.get().get単一市町村情報(), 処理前.get().get広域市町村情報(), 新旧被保険者番号変換区分);
        return Optional.of(処理後);
    }
}
