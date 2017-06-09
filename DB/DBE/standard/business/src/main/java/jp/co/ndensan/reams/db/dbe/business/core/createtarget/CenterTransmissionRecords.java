/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ作成用レコードを複数件保持します。
 */
public class CenterTransmissionRecords implements Iterable<CenterTransmissionRecord> {

    private final Map<RString, CenterTransmissionRecord> elements;

    private CenterTransmissionRecords(CenterTransmissionRecordsBuilder builder) {
        NCINinteiKeys keys = new NCINinteiKeys();
        Map<RString, CenterTransmissionRecord> map = new HashMap<>();
        for (ApplicationsResultMain entity : builder.申請結果Main) {
            NCINinteiKey key = keys.generateKey(entity.get保険者番号(), entity.get被保険者番号(), entity.get認定申請日());
            if (!key.isValid()) {
                continue;
            }
            map.put(entity.get申請書管理番号(), new CenterTransmissionRecord(entity, key.edaban()));
        }
        for (ExaminationsPartialResult 主治医項目 : builder.主治医意見書) {
            map.get(主治医項目.get申請書管理番号()).get主治医意見書().add(主治医項目);
        }
        for (ExaminationsPartialResult サービス項目 : builder.サービスの状況) {
            map.get(サービス項目.get申請書管理番号()).getサービスの状況().add(サービス項目);
        }
        for (ExaminationsPartialResult 調査項目 : builder.調査票調査項目) {
            map.get(調査項目.get申請書管理番号()).get調査票調査項目().add(調査項目);
        }
        for (ExaminationsPartialResult 前回調査項目 : builder.前回調査票調査項目) {
            map.get(前回調査項目.get申請書管理番号()).get前回調査票調査項目().add(前回調査項目);
        }
        for (ExaminationsPartialResult 前回サービス項目 : builder.前回サービスの状況) {
            map.get(前回サービス項目.get申請書管理番号()).get前回サービスの状況().add(前回サービス項目);
        }
        this.elements = Collections.unmodifiableMap(map);
    }

    /**
     * テスト用。指定の申請書管理番号に該当する要素を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 指定の申請書管理番号に該当する要素
     */
    CenterTransmissionRecord get(RString 申請書管理番号) {
        return this.elements.get(申請書管理番号);
    }

    @Override
    public Iterator<CenterTransmissionRecord> iterator() {
        return this.elements.values().iterator();
    }

    /**
     * {@link CenterTransmissionRecords} のビルダです。
     */
    public static final class CenterTransmissionRecordsBuilder {

        private List<ApplicationsResultMain> 申請結果Main;
        private List<ExaminationsPartialResult> 主治医意見書;
        private List<ExaminationsPartialResult> サービスの状況;
        private List<ExaminationsPartialResult> 調査票調査項目;
        private List<ExaminationsPartialResult> 前回調査票調査項目;
        private List<ExaminationsPartialResult> 前回サービスの状況;

        /**
         * インスタンスを生成します。
         */
        public CenterTransmissionRecordsBuilder() {
            this.主治医意見書 = new ArrayList<>();
            this.サービスの状況 = new ArrayList<>();
            this.調査票調査項目 = new ArrayList<>();
            this.前回調査票調査項目 = new ArrayList<>();
            this.前回サービスの状況 = new ArrayList<>();
        }

        /**
         * @param 申請結果Main 申請結果Main
         * @return {@link CenterTransmissionRecordsBuilder}
         */
        public CenterTransmissionRecordsBuilder setMain(List<ApplicationsResultMain> 申請結果Main) {
            this.申請結果Main = new ArrayList<>(申請結果Main);
            return this;
        }

        /**
         * @param 主治医意見書 主治医意見書
         * @return {@link CenterTransmissionRecordsBuilder}
         */
        public CenterTransmissionRecordsBuilder setIkensho(List<ExaminationsPartialResult> 主治医意見書) {
            this.主治医意見書 = new ArrayList<>(主治医意見書);
            return this;
        }

        /**
         * @param サービスの状況 サービスの状況
         * @return {@link CenterTransmissionRecordsBuilder}
         */
        public CenterTransmissionRecordsBuilder setServiceJokyo(List<ExaminationsPartialResult> サービスの状況) {
            this.サービスの状況 = new ArrayList<>(サービスの状況);
            return this;
        }

        /**
         * @param 調査票調査項目 調査票調査項目
         * @return {@link CenterTransmissionRecordsBuilder}
         */
        public CenterTransmissionRecordsBuilder setKihonChosa(List<ExaminationsPartialResult> 調査票調査項目) {
            this.調査票調査項目 = new ArrayList<>(調査票調査項目);
            return this;
        }

        /**
         * @param 前回調査票調査項目 前回調査票調査項目
         * @return {@link CenterTransmissionRecordsBuilder}
         */
        public CenterTransmissionRecordsBuilder setLastKihonChosa(List<ExaminationsPartialResult> 前回調査票調査項目) {
            this.前回調査票調査項目 = new ArrayList<>(前回調査票調査項目);
            return this;
        }

        /**
         * @param 前回サービスの状況 前回サービスの状況
         * @return {@link CenterTransmissionRecordsBuilder}
         */
        public CenterTransmissionRecordsBuilder setLastServiceJokyo(List<ExaminationsPartialResult> 前回サービスの状況) {
            this.前回サービスの状況 = new ArrayList<>(前回サービスの状況);
            return this;
        }

        /**
         * @return {@link CenterTransmissionRecords}
         */
        public CenterTransmissionRecords build() {
            return new CenterTransmissionRecords(this);
        }

    }

}
