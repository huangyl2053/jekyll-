/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoViewModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.basic.HihokenshaDaichoViewDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 広域内住所地特例者の情報を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KojutokushaFinder {

    private final HihokenshaDaichoViewDac dac;
    private final GaitoshaKensakuConfig config;

    private static final HihokenshaNo 被保険者番号未指定 = null;
    private static final boolean 措置元先制御あり = true;
    private static final boolean 措置元先制御なし = false;

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public KojutokushaFinder() {
        dac = InstanceProvider.create(HihokenshaDaichoViewDac.class);
        config = new GaitoshaKensakuConfig();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 被保険者台帳ビューDac
     * @param config 該当者検索Config
     */
    KojutokushaFinder(HihokenshaDaichoViewDac dac, GaitoshaKensakuConfig config) {
        this.dac = dac;
        this.config = config;
    }

    /**
     * 指定した被保険者番号に合致する広住特者の識別コードを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 識別コード
     */
    public Optional<ShikibetsuCode> get広住特者(HihokenshaNo 被保険者番号) {
        return get識別コード(被保険者番号);
    }

    /**
     * 指定した市町村コードに合致する広住特者の識別コードを返します。
     *
     * @param 市町村コード 市町村コード
     * @return 識別コード
     */
    public IItemList<ShikibetsuCode> get広住特者(LasdecCode 市町村コード) {
        return get識別コードList(市町村コード, 被保険者番号未指定, 措置元先制御なし);
    }

    /**
     * 指定した市町村コードに合致する広住特者の識別コードを返します。<br/>
     * コンフィグの設定により、対象の市町村は「措置元」「措置先」「措置元・措置先」の何れかとなります。
     *
     * @param 市町村コード 市町村コード
     * @return 識別コード
     */
    public IItemList<ShikibetsuCode> get広住特者_措置元先制御あり(LasdecCode 市町村コード) {
        return get識別コードList(市町村コード, 被保険者番号未指定, 措置元先制御あり);
    }

    /**
     * 指定した市町村コード、被保険者番号に合致する広住特者の識別コードを返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 識別コード
     */
    public IItemList<ShikibetsuCode> get広住特者(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        return get識別コードList(市町村コード, 被保険者番号, 措置元先制御なし);
    }

    /**
     * 指定した市町村コード、被保険者番号に合致する広住特者の識別コードを返します。<br/>
     * コンフィグの設定により、対象の市町村は「措置元」「措置先」「措置元・措置先」の何れかとなります。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 識別コード
     */
    public IItemList<ShikibetsuCode> get広住特者_措置元先制御あり(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        return get識別コードList(市町村コード, 被保険者番号, 措置元先制御あり);
    }

    private Optional<ShikibetsuCode> get識別コード(HihokenshaNo 被保険者番号) {
        IItemList<HihokenshaDaichoViewModel> daichoList = dac.selectBy被保険者番号(被保険者番号);
        return Optional.ofNullable(!daichoList.isEmpty() ? daichoList.toList().get(0).get識別コード() : null);
    }

    private IItemList<ShikibetsuCode> get識別コードList(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, boolean 出力制御) {
        return to識別コードList(出力制御
                ? get被保険者台帳List_措置元先制御あり(市町村コード, 被保険者番号)
                : dac.selectBy市町村コード(市町村コード, 被保険者番号));
    }

    private IItemList<HihokenshaDaichoViewModel> get被保険者台帳List_措置元先制御あり(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        switch (config.get措置元措置先区分_介護資格()) {
            case 措置元:
                return dac.selectBy市町村コード(市町村コード, 被保険者番号);
            case 措置先:
                return dac.selectBy広住特措置元市町村コード(市町村コード, 被保険者番号);
            case 措置元_措置先:
                return dac.selectByAny市町村コード(市町村コード, 被保険者番号);
            default:
                break;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("措置元・措置先区分").evaluate());
    }

    private IItemList<ShikibetsuCode> to識別コードList(IItemList<HihokenshaDaichoViewModel> daichoList) {
        List<ShikibetsuCode> codeList = new ArrayList<>();
        for (HihokenshaDaichoViewModel daicho : daichoList) {
            codeList.add(daicho.get識別コード());
        }
        return ItemList.of(codeList);
    }
}
