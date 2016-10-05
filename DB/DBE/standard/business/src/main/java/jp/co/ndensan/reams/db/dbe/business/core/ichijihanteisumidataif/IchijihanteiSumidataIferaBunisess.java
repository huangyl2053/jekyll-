/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 一次判定データ出力Bunisessです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public class IchijihanteiSumidataIferaBunisess {

    private final RString データ = new RString(" ");
    private final RString 識別コード = new RString("識別コード");
    private final RString 保険者番号 = new RString("保険者番号");
    private final RString 被保険者番号 = new RString("被保険者番号");
    private final RString 認定申請日 = new RString("認定申請日");
    private final RString 申請区分法令コード = new RString("申請区分(法令)コード");
    private final RString 申請区分申請時コード = new RString("申請区分(申請時)コード");
    private final RString 取下区分コード = new RString("取下区分コード");
    private final RString 被保険者区分コード = new RString("被保険者区分コード");
    private final RString 申請代行区分コード = new RString("申請代行区分コード");
    private final RString 生年月日 = new RString("生年月日");
    private final RString 性別コード = new RString("性別コード");
    private final RString 前回の認定審査会結果 = new RString("前回の認定審査会結果");
    private final RString 主治医医療機関番号 = new RString("主治医医療機関番号");
    private final RString 意見書依頼日 = new RString("意見書依頼日");
    private final RString 意見書入手日 = new RString("意見書入手日");
    private final RString 意見書短期記憶 = new RString("意見書「短期記憶」");
    private final RString 意見書認知能力 = new RString("意見書「認知能力」");
    private final RString 意見書伝達能力 = new RString("意見書「伝達能力」");
    private final RString 意見書食事行為 = new RString("意見書「食事行為」");
    private final RString 意見書認知症高齢者の日常生活自立度 = new RString("意見書「認知症高齢者の日常生活自立度」");
    private final RString 調査依頼日 = new RString("調査依頼日");
    private final RString 調査実施日 = new RString("調査実施日");
    private final RString 指定居宅介護支援事業者等番号 = new RString("指定居宅介護支援事業者等番号");
    private final RString 一次判定日 = new RString("一次判定日");
    private final RString 一次判定結果 = new RString("一次判定結果");
    private final RString 一次判定結果認知症加算 = new RString("一次判定結果（認知症加算）");
    private final RString 要介護認定等基準時間 = new RString("要介護認定等基準時間");
    private final RString 要介護認定等基準時間食事 = new RString("要介護認定等基準時間(食事)");
    private final RString 要介護認定等基準時間排泄 = new RString("要介護認定等基準時間(排泄)");
    private final RString 要介護認定等基準時間移動 = new RString("要介護認定等基準時間(移動)");
    private final RString 要介護認定等基準時間清潔保持 = new RString("要介護認定等基準時間(清潔保持)");
    private final RString 要介護認定等基準時間間接ケア = new RString("要介護認定等基準時間(間接ケア)");
    private final RString 要介護認定等基準時間BPSD関連 = new RString("要介護認定等基準時間(BPSD関連)");
    private final RString 要介護認定等基準時間機能訓練 = new RString("要介護認定等基準時間(機能訓練)");

    /**
     * エラーデータ処理。
     *
     * @param entity IchijihanteiSumidataIDataShutsuryokuRelateEntity
     * @return IchijihanteiSumidataIferaEucEntity
     */
    public RString setエラーデータ09B(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(entity.get厚労省IF識別コード())) {
            builder.append(識別コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get保険者番号())) {
            builder.append(保険者番号);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get被保険者番号())) {
            builder.append(被保険者番号);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get認定申請年月日())) {
            builder.append(認定申請日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get申請区分法令コード())) {
            builder.append(申請区分法令コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get申請区分申請時コード())) {
            builder.append(申請区分申請時コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get取下区分コード())) {
            builder.append(取下区分コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get被保険者区分コード())) {
            builder.append(被保険者区分コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get申請代行区分コート())) {
            builder.append(申請代行区分コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get生年月日())) {
            builder.append(生年月日);
            builder.append(データ);
        }
        setエラーデータ09B1(entity, builder);
        set一次判定エラーデータ(entity, builder);
        set一次判定エラーデータ1(entity, builder);
        setサービス区分コード(entity, builder);
        set調査項目(entity, builder);
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.get申請区分申請時コード())
                || NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.get申請区分申請時コード())) {
            set前回結果サービス区分コード(entity, builder);
            set前回結果一次判定エラーデータ(entity, builder);
        }
        return builder.toRString();
    }

    private void setエラーデータ09B1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get性別コード())) {
            builder.append(性別コード);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回要介護状態区分コード())) {
            builder.append(前回の認定審査会結果);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get主治医医療機関コード())) {
            builder.append(主治医医療機関番号);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get主治医意見書作成依頼年月日())) {
            builder.append(意見書依頼日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get主治医意見書受領年月日())) {
            builder.append(意見書入手日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get短期記憶15())) {
            builder.append(意見書短期記憶);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get日常の意思決定を行うための認知能力())) {
            builder.append(意見書認知能力);
            builder.append(データ);
        }
    }

    private void set一次判定エラーデータ(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get自分の意思の伝達能力())) {
            builder.append(意見書伝達能力);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get食事行為())) {
            builder.append(意見書食事行為);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get意見書認知症高齢者自立度())) {
            builder.append(意見書認知症高齢者の日常生活自立度);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get調査依頼日())) {
            builder.append(調査依頼日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get実施年月日())) {
            builder.append(調査実施日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get事業者番号())) {
            builder.append(指定居宅介護支援事業者等番号);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get一次判定日())) {
            builder.append(一次判定日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get一次判定結果())) {
            builder.append(一次判定結果);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get一次判定結果認知症加算())) {
            builder.append(一次判定結果認知症加算);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間())) {
            builder.append(要介護認定等基準時間);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間食事())) {
            builder.append(要介護認定等基準時間食事);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間排泄())) {
            builder.append(要介護認定等基準時間排泄);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間移動())) {
            builder.append(要介護認定等基準時間移動);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間清潔保持())) {
            builder.append(要介護認定等基準時間清潔保持);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間間接ケア())) {
            builder.append(要介護認定等基準時間間接ケア);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間BPSD関連())) {
            builder.append(要介護認定等基準時間BPSD関連);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間機能訓練())) {
            builder.append(要介護認定等基準時間機能訓練);
            builder.append(データ);
        }
    }

    private void set一次判定エラーデータ09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get自分の意思の伝達能力())) {
            builder.append(意見書伝達能力);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get食事行為())) {
            builder.append(意見書食事行為);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get意見書認知症高齢者自立度())) {
            builder.append(意見書認知症高齢者の日常生活自立度);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get実施年月日())) {
            builder.append(調査実施日);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get一次判定結果())) {
            builder.append(一次判定結果);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get一次判定結果認知症加算())) {
            builder.append(一次判定結果認知症加算);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間())) {
            builder.append(要介護認定等基準時間);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間食事())) {
            builder.append(要介護認定等基準時間食事);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間排泄())) {
            builder.append(要介護認定等基準時間排泄);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間移動())) {
            builder.append(要介護認定等基準時間移動);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間清潔保持())) {
            builder.append(要介護認定等基準時間清潔保持);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間間接ケア())) {
            builder.append(要介護認定等基準時間間接ケア);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間BPSD関連())) {
            builder.append(要介護認定等基準時間BPSD関連);
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間機能訓練())) {
            builder.append(要介護認定等基準時間機能訓練);
            builder.append(データ);
        }
    }

    private void set一次判定エラーデータ09A1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間認知症加算())) {
            builder.append(new RString("要介護認定等基準時間(認知症加算)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第1群())) {
            builder.append(new RString("中間評価項目得点第１群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第2群())) {
            builder.append(new RString("中間評価項目得点第２群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第3群())) {
            builder.append(new RString("中間評価項目得点第３群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第4群())) {
            builder.append(new RString("中間評価項目得点第４群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第5群())) {
            builder.append(new RString("中間評価項目得点第５群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get警告コード())) {
            builder.append(new RString("一次判定警告（配列）コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get状態の安定性())) {
            builder.append(new RString("状態の安定性"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get認知症自立度Ⅱ以上の蓋然性())) {
            builder.append(new RString("認知症自立度Ⅱ以上の蓋然性"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get給付区分())) {
            builder.append(new RString("認知機能及び状態安定性から推定される給付区分"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get施設利用())) {
            builder.append(new RString("現在の状況"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get障害高齢者自立度日常生活自立度())) {
            builder.append(new RString("障害高齢者自立度"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get認知症高齢者自立度日常生活自立度())) {
            builder.append(new RString("認知症高齢者自立度"));
            builder.append(データ);
        }
    }

    private void set一次判定エラーデータ1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get要介護認定等基準時間認知症加算())) {
            builder.append(new RString("要介護認定等基準時間(認知症加算)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第1群())) {
            builder.append(new RString("中間評価項目得点第１群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第2群())) {
            builder.append(new RString("中間評価項目得点第２群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第3群())) {
            builder.append(new RString("中間評価項目得点第３群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第4群())) {
            builder.append(new RString("中間評価項目得点第４群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get中間評価項目得点第5群())) {
            builder.append(new RString("中間評価項目得点第５群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get警告コード())) {
            builder.append(new RString("一次判定警告（配列）コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get状態の安定性())) {
            builder.append(new RString("状態の安定性"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get認知症自立度Ⅱ以上の蓋然性())) {
            builder.append(new RString("認知症自立度Ⅱ以上の蓋然性"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get給付区分())) {
            builder.append(new RString("認知機能及び状態安定性から推定される給付区分"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getサービス区分コード())) {
            builder.append(new RString("現在のサービス区分コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get施設利用())) {
            builder.append(new RString("現在の状況"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get障害高齢者自立度日常生活自立度())) {
            builder.append(new RString("障害高齢者自立度"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get認知症高齢者自立度日常生活自立度())) {
            builder.append(new RString("認知症高齢者自立度"));
            builder.append(データ);
        }
    }

    private void setサービス区分コード(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (new RString("2").equals(entity.getサービス区分コード())) {
            set介護給付サービス(entity, builder);
        }
        if (new RString("1").equals(entity.getサービス区分コード())) {
            set予防給付サービス(entity, builder);
        }
    }

    private void setサービス区分コード09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (new RString("2").equals(entity.getサービス区分コード())) {
            set介護給付サービス09A(entity, builder);
        }
        if (new RString("1").equals(entity.getサービス区分コード())) {
            set予防給付サービス(entity, builder);
        }
    }

    private void set前回結果サービス区分コード(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (new RString("2").equals(entity.get前回結果サービス区分コード())) {
            set前回結果介護給付サービス(entity, builder);
        }
        if (new RString("1").equals(entity.get前回結果サービス区分コード())) {
            set前回結果予防給付サービス(entity, builder);
        }
        set前回結果調査項目(entity, builder);
    }

    private void set前回結果サービス区分コード09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (new RString("2").equals(entity.get前回結果サービス区分コード())) {
            set前回結果介護給付サービス09A(entity, builder);
        }
        if (new RString("1").equals(entity.get前回結果サービス区分コード())) {
            set前回結果予防給付サービス(entity, builder);
        }
        set前回結果調査項目(entity, builder);
    }

    private void set介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get介護訪問介護ホームヘルプ())) {
            builder.append(new RString("訪問介護（ホームヘルプサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護訪問入浴介護())) {
            builder.append(new RString("訪問入浴介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護訪問看護())) {
            builder.append(new RString("訪問看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護訪問リハビリテーション())) {
            builder.append(new RString("訪問リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護居宅療養管理指導())) {
            builder.append(new RString("居宅療養管理指導"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護通所介護デイサービス())) {
            builder.append(new RString("通所介護（デイサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護通所リハビリテーションデイケア())) {
            builder.append(new RString("通所リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護短期入所生活介護ショートステイ())) {
            builder.append(new RString("短期入所生活介護（ショートステイ）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護短期入所療養介護())) {
            builder.append(new RString("短期入所療養介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護特定施設入居者生活介護())) {
            builder.append(new RString("特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護福祉用具貸与())) {
            builder.append(new RString("福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護特定福祉用具販売())) {
            builder.append(new RString("特定福祉用具販売"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get住宅改修介護給付())) {
            builder.append(new RString("住宅改修（介護給付）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護夜間対応型訪問介護())) {
            builder.append(new RString("夜間対応型訪問介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護認知症対応型通所介護())) {
            builder.append(new RString("認知症対応型通所介護"));
            builder.append(データ);
        }

        set介護給付サービス1(entity, builder);
    }

    private void set介護給付サービス1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get介護小規模多機能型居宅介護())) {
            builder.append(new RString("小規模多機能型居宅介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護認知症対応型共同生活介護グループホーム())) {
            builder.append(new RString("認知症対応型共同生活介護（グループホーム）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護地域密着型特定施設入居者生活介護())) {
            builder.append(new RString("地域密着型特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護地域密着型介護老人福祉施設入所者生活介護())) {
            builder.append(new RString("地域密着型介護老人福祉施設入所者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護定期巡回随時対応型訪問介護看護())) {
            builder.append(new RString("定期巡回・随時対応型訪問介護看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護複合型サービス())) {
            builder.append(new RString("複合型サービス"));
            builder.append(データ);
        }
    }

    private void set介護給付サービス09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get介護訪問介護ホームヘルプ())) {
            builder.append(new RString("訪問介護（ホームヘルプサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護訪問入浴介護())) {
            builder.append(new RString("訪問入浴介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護訪問看護())) {
            builder.append(new RString("訪問看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護訪問リハビリテーション())) {
            builder.append(new RString("訪問リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護居宅療養管理指導())) {
            builder.append(new RString("居宅療養管理指導"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護通所介護デイサービス())) {
            builder.append(new RString("通所介護（デイサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護通所リハビリテーションデイケア())) {
            builder.append(new RString("通所リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護短期入所生活介護ショートステイ())) {
            builder.append(new RString("短期入所生活介護（ショートステイ）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護短期入所療養介護())) {
            builder.append(new RString("短期入所療養介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護特定施設入居者生活介護())) {
            builder.append(new RString("特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護福祉用具貸与())) {
            builder.append(new RString("福祉用具貸与"));
            builder.append(データ);
        }
        set介護給付サービス09A1(entity, builder);
    }

    private void set介護給付サービス09A1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get介護特定福祉用具販売())) {
            builder.append(new RString("特定福祉用具販売"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get住宅改修介護給付())) {
            builder.append(new RString("住宅改修（介護給付）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護夜間対応型訪問介護())) {
            builder.append(new RString("夜間対応型訪問介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護認知症対応型通所介護())) {
            builder.append(new RString("認知症対応型通所介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護小規模多機能型居宅介護())) {
            builder.append(new RString("小規模多機能型居宅介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護認知症対応型共同生活介護グループホーム())) {
            builder.append(new RString("認知症対応型共同生活介護（グループホーム）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護地域密着型特定施設入居者生活介護())) {
            builder.append(new RString("地域密着型特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護地域密着型介護老人福祉施設入所者生活介護())) {
            builder.append(new RString("地域密着型介護老人福祉施設入所者生活介護"));
            builder.append(データ);
        }
    }

    private void set予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get予防訪問介護ホームヘルプ())) {
            builder.append(new RString("介護予防訪問介護（ホームヘルプサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防訪問入浴介護())) {
            builder.append(new RString("介護予防訪問入浴介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防訪問看護())) {
            builder.append(new RString("介護予防訪問看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防訪問リハビリテーション())) {
            builder.append(new RString("介護予防訪問リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防居宅療養管理指導())) {
            builder.append(new RString("介護予防居宅療養管理指導"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防通所介護デイサービス())) {
            builder.append(new RString("介護予防通所介護（デイサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防通所リハビリテーションデイケア())) {
            builder.append(new RString("介護予防通所リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防短期入所生活介護ショートステイ())) {
            builder.append(new RString("介護予防短期入所生活介護（ショートステイ）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防短期入所療養介護())) {
            builder.append(new RString("介護予防短期入所療養介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防特定施設入居者生活介護())) {
            builder.append(new RString("介護予防特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防福祉用具貸与())) {
            builder.append(new RString("介護予防福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防特定福祉用具販売())) {
            builder.append(new RString("介護予防福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get住宅改修予防給付())) {
            builder.append(new RString("住宅改修（予防給付）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防認知症対応型通所介護())) {
            builder.append(new RString("介護予防認知症対応型通所介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防小規模多機能型居宅介護())) {
            builder.append(new RString("介護予防小規模多機能型居宅介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get予防認知症対応型共同生活介護グループホーム())) {
            builder.append(new RString("介護予防認知症対応型共同生活介護（グループホーム）"));
            builder.append(データ);
        }
    }

    private void set調査項目(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get中心静脈栄養())) {
            builder.append(new RString("中心静脈栄養"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get透析())) {
            builder.append(new RString("透析"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getストーマの処置())) {
            builder.append(new RString("ストーマの処置"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get酸素療法())) {
            builder.append(new RString("酸素療法"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getレスピレーター())) {
            builder.append(new RString("レスピレーター"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get気管切開の処置())) {
            builder.append(new RString("気管切開の処置"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get疼痛の看護())) {
            builder.append(new RString("疼痛の看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get経管栄養())) {
            builder.append(new RString("経管栄養"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getモニター測定())) {
            builder.append(new RString("モニター測定"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getじょくそうの処置())) {
            builder.append(new RString("じょくそうの処置"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getカテーテル())) {
            builder.append(new RString("カテーテル"));
            builder.append(データ);
        }
        set調査項目1(entity, builder);
        set調査項目2(entity, builder);
        set調査項目3(entity, builder);
        set調査項目4(entity, builder);
    }

    private void set調査項目1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get麻痺左上肢())) {
            builder.append(new RString("０１麻痺（左-上肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get麻痺右上肢())) {
            builder.append(new RString("０１麻痺（右-上肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get麻痺左下肢())) {
            builder.append(new RString("０１麻痺（左-下肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get麻痺右下肢())) {
            builder.append(new RString("０１麻痺（右-下肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get麻痺その他())) {
            builder.append(new RString("０１麻痺（その他）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get拘縮肩関節())) {
            builder.append(new RString("０１拘縮（肩関節）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get拘縮股関節())) {
            builder.append(new RString("０１拘縮（股関節）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get拘縮膝関節())) {
            builder.append(new RString("０１拘縮（膝関節）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get拘縮その他())) {
            builder.append(new RString("０１拘縮（その他）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get寝返り())) {
            builder.append(new RString("０１寝返り"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get起き上がり())) {
            builder.append(new RString("０１起き上がり"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get座位保持())) {
            builder.append(new RString("０１座位保持"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get両足での立位())) {
            builder.append(new RString("０１両足での立位"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get歩行())) {
            builder.append(new RString("０１歩行"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get立ち上がり())) {
            builder.append(new RString("０１立ち上がり"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get片足での立位())) {
            builder.append(new RString("０１片足での立位"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get洗身())) {
            builder.append(new RString("０１洗身"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getつめ切り())) {
            builder.append(new RString("０１つめ切り"));
            builder.append(データ);
        }
    }

    private void set調査項目2(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get視力())) {
            builder.append(new RString("０１視力"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get聴力())) {
            builder.append(new RString("０１聴力"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get移乗())) {
            builder.append(new RString("０２移乗"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get移動())) {
            builder.append(new RString("０２移動"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getえん下())) {
            builder.append(new RString("０２えん下"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get食事摂取())) {
            builder.append(new RString("０２食事摂取"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get排尿())) {
            builder.append(new RString("０２排尿"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get排便())) {
            builder.append(new RString("０２排便"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get口腔清潔())) {
            builder.append(new RString("０２口腔清潔"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get洗顔())) {
            builder.append(new RString("０２洗顔"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get整髪())) {
            builder.append(new RString("０２整髪"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get上衣の着脱())) {
            builder.append(new RString("０２上衣の着脱"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getズボン等の着脱())) {
            builder.append(new RString("０２ズボン等の着脱"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get外出頻度())) {
            builder.append(new RString("０２外出頻度"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get意思の伝達())) {
            builder.append(new RString("０３意思の伝達"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get毎日の日課を理解())) {
            builder.append(new RString("０３毎日の日課を理解"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get生年月日をいう())) {
            builder.append(new RString("０３生年月日をいう"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get短期記憶())) {
            builder.append(new RString("０３短期記憶"));
            builder.append(データ);
        }
    }

    private void set調査項目3(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get自分の名前をいう())) {
            builder.append(new RString("０３自分の名前をいう"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get今の季節を理解())) {
            builder.append(new RString("０３今の季節を理解"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get場所の理解())) {
            builder.append(new RString("０３場所の理解"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get徘徊())) {
            builder.append(new RString("０３徘徊"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get外出して戻れない())) {
            builder.append(new RString("０３外出して戻れない"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get被害的())) {
            builder.append(new RString("０４被害的"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get作話())) {
            builder.append(new RString("０４作話"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get感情が不安定())) {
            builder.append(new RString("０４感情が不安定"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get昼夜逆転())) {
            builder.append(new RString("０４昼夜逆転"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get同じ話をする())) {
            builder.append(new RString("０４同じ話をする"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get大声を出す())) {
            builder.append(new RString("０４大声を出す"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get介護に抵抗())) {
            builder.append(new RString("０４介護に抵抗"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get落ち着きなし())) {
            builder.append(new RString("０４落ち着きなし"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get一人で出たがる())) {
            builder.append(new RString("０４一人で出たがる"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get収集癖())) {
            builder.append(new RString("０４収集癖"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get物や衣類を壊す())) {
            builder.append(new RString("０４物や衣類を壊す"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.getひどい物忘れ())) {
            builder.append(new RString("０４ひどい物忘れ"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get独り言独り笑い())) {
            builder.append(new RString("０４独り言・独り笑い"));
            builder.append(データ);
        }
    }

    private void set調査項目4(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get自分勝手に行動する())) {
            builder.append(new RString("０４自分勝手に行動する"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get話がまとまらない())) {
            builder.append(new RString("０４話がまとまらない"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get薬の内服())) {
            builder.append(new RString("０５薬の内服"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get金銭の管理())) {
            builder.append(new RString("０５金銭の管理"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get日常の意思決定())) {
            builder.append(new RString("０５日常の意思決定"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get集団への不適応())) {
            builder.append(new RString("０５集団への不適応"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get買い物())) {
            builder.append(new RString("０５買い物"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get簡単な調理())) {
            builder.append(new RString("０５簡単な調理"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get点滴の管理())) {
            builder.append(new RString("点滴の管理"));
            builder.append(データ);
        }
    }

    private void set前回結果介護給付サービス09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回介護訪問介護ホームヘルプ())) {
            builder.append(new RString("前回結果訪問介護（ホームヘルプサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護訪問入浴介護())) {
            builder.append(new RString("前回結果訪問入浴介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護訪問看護())) {
            builder.append(new RString("前回結果訪問看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護訪問リハビリテーション())) {
            builder.append(new RString("前回結果訪問リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護居宅療養管理指導())) {
            builder.append(new RString("前回結果居宅療養管理指導"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護通所介護デイサービス())) {
            builder.append(new RString("前回結果通所介護（デイサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護通所リハビリテーションデイケア())) {
            builder.append(new RString("前回結果通所リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護短期入所生活介護ショートステイ())) {
            builder.append(new RString("前回結果短期入所生活介護（ショートステイ）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護短期入所療養介護())) {
            builder.append(new RString("前回結果短期入所療養介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護特定施設入居者生活介護())) {
            builder.append(new RString("前回結果特定施設入居者生活介護"));
            builder.append(データ);
        }

        if (RString.isNullOrEmpty(entity.get前回介護地域密着型介護老人福祉施設入所者生活介護())) {
            builder.append(new RString("前回結果地域密着型介護老人福祉施設入所者生活介護"));
            builder.append(データ);
        }
        set前回結果介護給付サービス09A1(entity, builder);
    }

    private void set前回結果介護給付サービス09A1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回介護福祉用具貸与())) {
            builder.append(new RString("前回結果福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護特定福祉用具販売())) {
            builder.append(new RString("前回結果特定福祉用具販売"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回住宅改修介護給付())) {
            builder.append(new RString("前回結果住宅改修（介護給付）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護夜間対応型訪問介護())) {
            builder.append(new RString("前回結果夜間対応型訪問介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護認知症対応型通所介護())) {
            builder.append(new RString("前回結果認知症対応型通所介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護小規模多機能型居宅介護())) {
            builder.append(new RString("前回結果小規模多機能型居宅介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護認知症対応型共同生活介護グループホーム())) {
            builder.append(new RString("前回結果認知症対応型共同生活介護（グループホーム）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護地域密着型特定施設入居者生活介護())) {
            builder.append(new RString("前回結果地域密着型特定施設入居者生活介護"));
            builder.append(データ);
        }
    }

    private void set前回結果介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回介護訪問介護ホームヘルプ())) {
            builder.append(new RString("前回結果訪問介護（ホームヘルプサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護訪問入浴介護())) {
            builder.append(new RString("前回結果訪問入浴介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護訪問看護())) {
            builder.append(new RString("前回結果訪問看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護訪問リハビリテーション())) {
            builder.append(new RString("前回結果訪問リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護居宅療養管理指導())) {
            builder.append(new RString("前回結果居宅療養管理指導"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護通所介護デイサービス())) {
            builder.append(new RString("前回結果通所介護（デイサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護通所リハビリテーションデイケア())) {
            builder.append(new RString("前回結果通所リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護短期入所生活介護ショートステイ())) {
            builder.append(new RString("前回結果短期入所生活介護（ショートステイ）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護短期入所療養介護())) {
            builder.append(new RString("前回結果短期入所療養介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護特定施設入居者生活介護())) {
            builder.append(new RString("前回結果特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護福祉用具貸与())) {
            builder.append(new RString("前回結果福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護特定福祉用具販売())) {
            builder.append(new RString("前回結果特定福祉用具販売"));
            builder.append(データ);
        }
        set前回結果介護給付サービス1(entity, builder);
    }

    private void set前回結果介護給付サービス1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回住宅改修介護給付())) {
            builder.append(new RString("前回結果住宅改修（介護給付）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護夜間対応型訪問介護())) {
            builder.append(new RString("前回結果夜間対応型訪問介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護認知症対応型通所介護())) {
            builder.append(new RString("前回結果認知症対応型通所介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護小規模多機能型居宅介護())) {
            builder.append(new RString("前回結果小規模多機能型居宅介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護認知症対応型共同生活介護グループホーム())) {
            builder.append(new RString("前回結果認知症対応型共同生活介護（グループホーム）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護地域密着型特定施設入居者生活介護())) {
            builder.append(new RString("前回結果地域密着型特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護地域密着型介護老人福祉施設入所者生活介護())) {
            builder.append(new RString("前回結果地域密着型介護老人福祉施設入所者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護定期巡回随時対応型訪問介護看護())) {
            builder.append(new RString("前回結果定期巡回・随時対応型訪問介護看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回介護複合型サービス())) {
            builder.append(new RString("前回結果複合型サービス"));
            builder.append(データ);
        }
    }

    private void set前回結果予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回予防訪問介護ホームヘルプ())) {
            builder.append(new RString("前回結果介護予防訪問介護（ホームヘルプサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防訪問入浴介護())) {
            builder.append(new RString("前回結果介護予防訪問入浴介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防訪問看護())) {
            builder.append(new RString("前回結果介護予防訪問看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防訪問リハビリテーション())) {
            builder.append(new RString("前回結果介護予防訪問リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防居宅療養管理指導())) {
            builder.append(new RString("前回結果介護予防居宅療養管理指導"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防通所介護デイサービス())) {
            builder.append(new RString("前回結果介護予防通所介護（デイサービス）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防通所リハビリテーションデイケア())) {
            builder.append(new RString("前回結果介護予防通所リハビリテーション"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防短期入所生活介護ショートステイ())) {
            builder.append(new RString("前回結果介護予防短期入所生活介護（ショートステイ）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防短期入所療養介護())) {
            builder.append(new RString("前回結果介護予防短期入所療養介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防特定施設入居者生活介護())) {
            builder.append(new RString("前回結果介護予防特定施設入居者生活介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防福祉用具貸与())) {
            builder.append(new RString("前回結果介護予防福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防特定福祉用具販売())) {
            builder.append(new RString("前回結果介護予防福祉用具貸与"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回住宅改修予防給付())) {
            builder.append(new RString("前回結果住宅改修（予防給付）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防認知症対応型通所介護())) {
            builder.append(new RString("前回結果介護予防認知症対応型通所介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防小規模多機能型居宅介護())) {
            builder.append(new RString("前回結果介護予防小規模多機能型居宅介護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回予防認知症対応型共同生活介護グループホーム())) {
            builder.append(new RString("前回結果介護予防認知症対応型共同生活介護（グループホーム）"));
            builder.append(データ);
        }
    }

    private void set前回結果一次判定エラーデータ(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回認定有効期間開始())) {
            builder.append(new RString("前回の認定有効期間（開始）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回認定有効期間終了())) {
            builder.append(new RString("前回の認定有効期間（終了）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果障害高齢者自立度日常生活自立度())) {
            builder.append(new RString("前回結果障害高齢者自立度"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果認知症高齢者自立度日常生活自立度())) {
            builder.append(new RString("前回結果認知症高齢者自立度"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果一次判定結果認知症加算())) {
            builder.append(new RString("前回結果一次判定結果（認知症加算）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間())) {
            builder.append(new RString("前回結果要介護認定等基準時間"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間食事())) {
            builder.append(new RString("前回結果要介護認定等基準時間(食事)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間排泄())) {
            builder.append(new RString("前回結果要介護認定等基準時間(排泄)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間移動())) {
            builder.append(new RString("前回結果要介護認定等基準時間(移動)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間清潔保持())) {
            builder.append(new RString("前回結果要介護認定等基準時間(清潔保持)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間間接ケア())) {
            builder.append(new RString("前回結果要介護認定等基準時間(間接ケア)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間BPSD関連())) {
            builder.append(new RString("前回結果要介護認定等基準時間(BPSD関連)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間機能訓練())) {
            builder.append(new RString("前回結果要介護認定等基準時間(機能訓練)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間BPSD関連())) {
            builder.append(new RString("前回結果要介護認定等基準時間(BPSD関連)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果要介護認定等基準時間認知症加算())) {
            builder.append(new RString("前回結果要介護認定等基準時間(認知症加算)"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果中間評価項目得点第1群())) {
            builder.append(new RString("前回結果中間評価項目得点第１群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果中間評価項目得点第2群())) {
            builder.append(new RString("前回結果中間評価項目得点第２群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果中間評価項目得点第3群())) {
            builder.append(new RString("前回結果中間評価項目得点第３群"));
            builder.append(データ);
        }
        set前回結果一次判定エラーデータ1(entity, builder);
    }

    private void set前回結果一次判定エラーデータ1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回結果中間評価項目得点第4群())) {
            builder.append(new RString("前回結果中間評価項目得点第４群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果中間評価項目得点第5群())) {
            builder.append(new RString("中間評価項目得点第５群"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果警告コード())) {
            builder.append(new RString("前回結果一次判定警告（配列）コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果状態の安定性())) {
            builder.append(new RString("前回結果状態の安定性"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果認知症自立度Ⅱ以上の蓋然性())) {
            builder.append(new RString("前回結果認知症自立度Ⅱ以上の蓋然性"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果給付区分())) {
            builder.append(new RString("前回結果認知機能及び状態安定性から推定される給付区分"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果サービス区分コード())) {
            builder.append(new RString("前回結果現在のサービス区分コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果施設利用())) {
            builder.append(new RString("前回結果現在の状況"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回識別コード())) {
            builder.append(new RString("前回識別コード"));
            builder.append(データ);
        }
    }

    private void set前回結果調査項目(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {

        if (RString.isNullOrEmpty(entity.get前回結果薬の内服())) {
            builder.append(new RString("前回結果０５薬の内服"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果金銭の管理())) {
            builder.append(new RString("前回結果０５金銭の管理"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果日常の意思決定())) {
            builder.append(new RString("前回結果０５日常の意思決定"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果集団への不適応())) {
            builder.append(new RString("前回結果０５集団への不適応"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果買い物())) {
            builder.append(new RString("前回結果０５買い物"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果簡単な調理())) {
            builder.append(new RString("前回結果０５簡単な調理"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果点滴の管理())) {
            builder.append(new RString("前回結果点滴の管理"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果中心静脈栄養())) {
            builder.append(new RString("前回結果中心静脈栄養"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果透析())) {
            builder.append(new RString("前回結果透析"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果ストーマの処置())) {
            builder.append(new RString("前回結果ストーマの処置"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果酸素療法())) {
            builder.append(new RString("前回結果酸素療法"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果レスピレーター())) {
            builder.append(new RString("前回結果レスピレーター"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果気管切開の処置())) {
            builder.append(new RString("前回結果気管切開の処置"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果疼痛の看護())) {
            builder.append(new RString("前回結果疼痛の看護"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果経管栄養())) {
            builder.append(new RString("前回結果経管栄養"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果モニター測定())) {
            builder.append(new RString("前回結果モニター測定"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果じょくそうの処置())) {
            builder.append(new RString("前回結果じょくそうの処置"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果カテーテル())) {
            builder.append(new RString("前回結果カテーテル"));
            builder.append(データ);
        }
        set前回結果調査項目1(entity, builder);
        set前回結果調査項目2(entity, builder);
        set前回結果調査項目3(entity, builder);
        set前回結果調査項目4(entity, builder);
    }

    private void set前回結果調査項目1(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回結果麻痺左上肢())) {
            builder.append(new RString("前回結果０１麻痺（左-上肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果麻痺右上肢())) {
            builder.append(new RString("前回結果０１麻痺（右-上肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果麻痺左下肢())) {
            builder.append(new RString("前回結果０１麻痺（左-下肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果麻痺右下肢())) {
            builder.append(new RString("前回結果０１麻痺（右-下肢）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果麻痺その他())) {
            builder.append(new RString("前回結果０１麻痺（その他）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果拘縮肩関節())) {
            builder.append(new RString("前回結果０１拘縮（肩関節）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果拘縮股関節())) {
            builder.append(new RString("前回結果０１拘縮（股関節）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果拘縮膝関節())) {
            builder.append(new RString("前回結果０１拘縮（膝関節）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果拘縮その他())) {
            builder.append(new RString("前回結果０１拘縮（その他）"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果寝返り())) {
            builder.append(new RString("前回結果０１寝返り"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果起き上がり())) {
            builder.append(new RString("前回結果０１起き上がり"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果座位保持())) {
            builder.append(new RString("前回結果０１座位保持"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果両足での立位())) {
            builder.append(new RString("前回結果０１両足での立位"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果歩行())) {
            builder.append(new RString("前回結果０１歩行"));
            builder.append(データ);
        }
    }

    private void set前回結果調査項目2(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回結果立ち上がり())) {
            builder.append(new RString("前回結果０１立ち上がり"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果片足での立位())) {
            builder.append(new RString("前回結果０１片足での立位"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果洗身())) {
            builder.append(new RString("前回結果０１洗身"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果つめ切り())) {
            builder.append(new RString("前回結果０１つめ切り"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果視力())) {
            builder.append(new RString("前回結果０１視力"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果聴力())) {
            builder.append(new RString("前回結果０１聴力"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果移乗())) {
            builder.append(new RString("前回結果０２移乗"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果移動())) {
            builder.append(new RString("前回結果０２移動"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果えん下())) {
            builder.append(new RString("前回結果０２えん下"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果食事摂取())) {
            builder.append(new RString("前回結果０２食事摂取"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果排尿())) {
            builder.append(new RString("前回結果０２排尿"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果排便())) {
            builder.append(new RString("前回結果０２排便"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果口腔清潔())) {
            builder.append(new RString("前回結果０２口腔清潔"));
            builder.append(データ);
        }
    }

    private void set前回結果調査項目3(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回結果洗顔())) {
            builder.append(new RString("前回結果０２洗顔"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果整髪())) {
            builder.append(new RString("前回結果０２整髪"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果上衣の着脱())) {
            builder.append(new RString("前回結果０２上衣の着脱"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果ズボン等の着脱())) {
            builder.append(new RString("前回結果０２ズボン等の着脱"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果外出頻度())) {
            builder.append(new RString("前回結果０２外出頻度"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果意思の伝達())) {
            builder.append(new RString("前回結果０３意思の伝達"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果毎日の日課を理解())) {
            builder.append(new RString("前回結果０３毎日の日課を理解"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果生年月日をいう())) {
            builder.append(new RString("前回結果０３生年月日をいう"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果短期記憶())) {
            builder.append(new RString("前回結果０３短期記憶"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果自分の名前をいう())) {
            builder.append(new RString("前回結果０３自分の名前をいう"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果今の季節を理解())) {
            builder.append(new RString("前回結果０３今の季節を理解"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果場所の理解())) {
            builder.append(new RString("前回結果０３場所の理解"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果徘徊())) {
            builder.append(new RString("前回結果０３徘徊"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果外出して戻れない())) {
            builder.append(new RString("前回結果０３外出して戻れない"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果被害的())) {
            builder.append(new RString("前回結果０４被害的"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果作話())) {
            builder.append(new RString("前回結果０４作話"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果感情が不安定())) {
            builder.append(new RString("前回結果０４感情が不安定"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果昼夜逆転())) {
            builder.append(new RString("前回結果０４昼夜逆転"));
            builder.append(データ);
        }
    }

    private void set前回結果調査項目4(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity, RStringBuilder builder) {
        if (RString.isNullOrEmpty(entity.get前回結果同じ話をする())) {
            builder.append(new RString("前回結果０４同じ話をする"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果大声を出す())) {
            builder.append(new RString("前回結果０４大声を出す"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果介護に抵抗())) {
            builder.append(new RString("前回結果０４介護に抵抗"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果落ち着きなし())) {
            builder.append(new RString("前回結果０４落ち着きなし"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果一人で出たがる())) {
            builder.append(new RString("前回結果０４一人で出たがる"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果収集癖())) {
            builder.append(new RString("前回結果０４収集癖"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果物や衣類を壊す())) {
            builder.append(new RString("前回結果０４物や衣類を壊す"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果ひどい物忘れ())) {
            builder.append(new RString("前回結果０４ひどい物忘れ"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果独り言独り笑い())) {
            builder.append(new RString("前回結果０４独り言・独り笑い"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果自分勝手に行動する())) {
            builder.append(new RString("前回結果０４自分勝手に行動する"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get前回結果話がまとまらない())) {
            builder.append(new RString("前回結果０４話がまとまらない"));
            builder.append(データ);
        }
    }

    /**
     * エラーデータ09A処理。
     *
     * @param entity IchijihanteiSumidataIDataShutsuryokuRelateEntity
     * @return IchijihanteiSumidataIferaEucEntity
     */
    public RString setエラーデータ09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(entity.get厚労省IF識別コード())) {
            builder.append(new RString("識別コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get保険者番号())) {
            builder.append(new RString("保険者番号"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get被保険者番号())) {
            builder.append(new RString("被保険者番号"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get認定申請年月日())) {
            builder.append(new RString("認定申請日"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get申請区分申請時コード())) {
            builder.append(new RString("申請種別コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get取下区分コード())) {
            builder.append(new RString("取下区分コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get被保険者区分コード())) {
            builder.append(new RString("被保険者区分コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get申請代行区分コート())) {
            builder.append(new RString("申請代行区分コード"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get生年月日())) {
            builder.append(new RString("生年月日"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get短期記憶15())) {
            builder.append(new RString("意見書「短期記憶」"));
            builder.append(データ);
        }
        if (RString.isNullOrEmpty(entity.get日常の意思決定を行うための認知能力())) {
            builder.append(new RString("意見書「認知能力」"));
            builder.append(データ);
        }
        set一次判定エラーデータ09A(entity, builder);
        set一次判定エラーデータ09A1(entity, builder);
        setサービス区分コード09A(entity, builder);
        set調査項目(entity, builder);
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.get申請区分申請時コード())
                || NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.get申請区分申請時コード())) {
            set前回結果サービス区分コード09A(entity, builder);
            set前回結果一次判定エラーデータ(entity, builder);
        }
        return builder.toRString();

    }
}
