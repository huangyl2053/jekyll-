/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.viewstate;

/**
 * 介護ののViewStateKeys
 *
 * @reamsid_L DBX-9999-023 wangchao
 */
public enum ViewStateKeys {

    /**
     * 遷移元区分
     */
    遷移元区分,
    /**
     * 算定期
     */
    算定期,
    /**
     * 審査会開催番号
     */
    審査会開催番号,
    /**
     * キーが「識別コード」であることを表します
     */
    識別コード,
    /**
     * キーが「被保険者番号」であることを表します
     */
    被保険者番号,
    /**
     * キーが「広域内市町村情報」であることを表します
     */
    広域内市町村情報,
    /**
     * キーが「資格対象者」であることを表します
     */
    資格対象者,
    /**
     * キーが「賦課対象者」であることを表します。
     */
    賦課対象者,
    /**
     * 負担限度額認定申請の情報
     */
    負担限度額認定申請の情報,
    /**
     * new負担限度額認定申請の情報
     */
    new負担限度額認定申請の情報,
    /**
     * isReRequest
     */
    isReRequest,
    /**
     * 申請書管理番号
     */
    申請書管理番号,
    /**
     * 主治医意見書作成依頼履歴番号
     */
    主治医意見書作成依頼履歴番号,
    /**
     * 認定調査履歴番号
     */
    認定調査履歴番号,
    /**
     * 認定調査依頼情報
     */
    認定調査依頼情報,
    /**
     * 主治医意見書依頼情報
     */
    主治医意見書依頼情報,
    /**
     * タスク一覧_要介護認定完了情報
     */
    タスク一覧_要介護認定完了情報,
    /**
     * 認定調査履歴番号
     */
    調査実施日,
    /**
     * 調査実施場所
     */
    調査実施場所,
    /**
     * 実施場所名称
     */
    実施場所名称,
    /**
     * 所属機関
     */
    所属機関,
    /**
     * 記入者
     */
    記入者,
    /**
     * 帳票分類ID
     */
    帳票分類ID,
    /**
     * 帳票分類名称
     */
    帳票分類名称,
    /**
     * 転入保留対象者
     */
    転入保留対象者,
    /**
     * 転出保留対象者
     */
    転出保留対象者,
    /**
     * 広域転入保留対象者
     */
    広域転入保留対象者,
    /**
     * 転出保留対象者宛名
     */
    転出保留対象者宛名,
    /**
     * 開催予定日
     */
    開催予定日,
    /**
     * 審査会会場
     */
    審査会会場,
    /**
     * 開始予定時間
     */
    開始予定時間,
    /**
     * 資料作成
     */
    資料作成,
    /**
     * 合議体番号
     */
    合議体番号,
    /**
     * 合議体名称
     */
    合議体名称,
    /**
     * 予定定員
     */
    予定定員,
    /**
     * 割付人数
     */
    割付人数,
    /**
     * 開催番号
     */
    開催番号,
    /**
     * 処理日
     */
    処理日,
    /**
     * みなし2号登録情報
     */
    みなし2号登録情報,
    /**
     * 申請書管理番号リスト
     */
    申請書管理番号リスト,
    /**
     * 調査区分
     */
    調査区分,
    /**
     * 出力条件
     */
    出力条件,
    /**
     * 第一群認定調査基本情報リスト
     */
    第一群認定調査基本情報リスト,
    /**
     * 第二群認定調査基本情報リスト
     */
    第二群認定調査基本情報リスト,
    /**
     * 第三群認定調査基本情報リスト
     */
    第三群認定調査基本情報リスト,
    /**
     * 第四群認定調査基本情報リスト
     */
    第四群認定調査基本情報リスト,
    /**
     * 第五群認定調査基本情報リスト
     */
    第五群認定調査基本情報リスト,
    /**
     * 第六群認定調査基本情報リスト
     */
    第六群認定調査基本情報リスト,
    /**
     * 第七群認定調査基本情報リスト
     */
    第七群認定調査基本情報リスト,
    /**
     * 介護問合せ先情報
     */
    介護問合せ先情報,
    /**
     * 支所コード
     */
    支所コード,
    /**
     * 証記載保険者番号
     */
    証記載保険者番号,
    /**
     * 認定調査委託先コード
     */
    認定調査委託先コード,
    /**
     * 調査員コード
     */
    調査員コード,
    /**
     * 要介護認定完了情報
     */
    要介護認定完了情報,
    /**
     * 保険者名称
     */
    保険者名称,
    /**
     * 認定調査委託先割付定員
     */
    認定調査委託先割付定員,
    /**
     * 調査員割付可能人数/月
     */
    調査員割付可能人数_月,
    /**
     * 帳票制御汎用メンテナンスGrid
     */
    帳票制御汎用メンテナンスGrid,
    /**
     * 利用者負担額減額情報のDBList
     */
    利用者負担額減額情報のDBList,
    /**
     * 利用者負担額減額情報ListのViewState
     */
    利用者負担額減額情報ListのViewState,
    /**
     * 該当DB申請
     */
    該当DB申請,
    /**
     * 該当申請のViewState
     */
    該当申請のViewState,
    /**
     * 新規申請の履歴番号
     */
    新規申請の履歴番号,
    /**
     * 世帯所得一覧初期化済み
     */
    世帯所得一覧初期化済み,
    /**
     * 介護認定審査会番号
     */
    介護認定審査会番号,
    /**
     * キーが「賦課照会キー」であることを表します。
     */
    賦課照会キー,
    /**
     * キーが「前履歴キー」であることを表します。
     */
    前履歴キー,
    /**
     * キーが「賦課比較キー」であることを表します。
     */
    賦課比較キー,
    /**
     * 審査請求届出日
     */
    審査請求届出日,
    /**
     * 弁明書作成日
     */
    弁明書作成日,
    /**
     * モード
     */
    モード,
    /**
     * 弁明登録情報
     */
    弁明登録情報,
    /**
     * 不服審査申立情報
     */
    不服審査申立情報,
    /**
     * 弁明内容
     */
    弁明内容,
    /**
     * 弁明者情報
     */
    弁明者情報,
    /**
     * 補正検索画面情報
     */
    補正検索画面情報,
    /**
     * 開催場所情報一覧
     */
    開催場所情報一覧,
    /**
     * 保険料収納状況データ
     */
    保険料収納状況データ,
    /**
     * 保険給付支払状況データ
     */
    保険給付支払状況データ,
    /**
     * 件数データグリッド。
     */
    件数データグリッド,
    /**
     * 費用額データグリッド。
     */
    費用額データグリッド,
    /**
     * 給付額データグリッド。
     */
    給付額データグリッド,
    /**
     * 状態
     */
    状態,
    /**
     * 認定調査員マスタ検索結果
     */
    認定調査員マスタ検索結果,
    /**
     * 合議体情報
     */
    合議体情報,
    /**
     * 審査会開催結果登録
     */
    審査会開催結果登録,
    /**
     * 合議体情報更新
     */
    合議体情報更新,
    /**
     * 主治医マスタ検索結果
     */
    主治医マスタ検索結果,
    /**
     * 主治医医療機関マスタ検索結果
     */
    主治医医療機関マスタ検索結果,
    /**
     * 調査地区グループ調査地区一覧検索結果
     */
    調査地区グループ調査地区一覧結果,
    /**
     * 台帳種別表示
     */
    台帳種別表示,
    /**
     * 施設入退所情報
     */
    施設入退所情報,
    /**
     * 被保険者
     */
    被保険者,
    /**
     * 他市町村住所地特例者
     */
    他市町村住所地特例者,
    /**
     * 適用除外者
     */
    適用除外者,
    /**
     * 介護認定審査会委員情報
     */
    介護認定審査会委員情報,
    /**
     * 介護認定審査会委員情報更新
     */
    介護認定審査会委員情報更新,
    /**
     * 医療保険情報
     */
    医療保険情報,
    /**
     * 決定情報
     */
    決定情報,
    /**
     * 業務区分
     */
    業務区分,
    /**
     * サービス提供年月
     */
    サービス提供年月,
    /**
     * 整理番号
     */
    整理番号,
    /**
     * 支払金額合計
     */
    支払金額合計,
    /**
     * 支給申請情報パラメータ
     */
    支給申請情報パラメータ,
    /**
     * 業務内区分コード
     */
    業務内区分コード,
    /**
     * 償還払申請一覧
     */
    償還払申請一覧,
    /**
     * サービス年月
     */
    サービス年月,
    /**
     * サービス年月From
     */
    サービス年月From,
    /**
     * サービス年月To
     */
    サービス年月To,
    /**
     * 決定日
     */
    決定日,
    /**
     * 申請日
     */
    申請日,
    /**
     * 事業者番号
     */
    事業者番号,
    /**
     * 明細番号
     */
    明細番号,
    /**
     * 様式番号
     */
    様式番号,
    /**
     * 履歴番号
     */
    履歴番号,
    /**
     * 老健受給情報
     */
    老健受給情報,
    /**
     * 商品名
     */
    商品名,
    /**
     * 製造事業者
     */
    製造事業者,
    /**
     * 品目コード
     */
    品目コード,
    /**
     * 福祉用具商品名入力ガイド検索結果
     */
    福祉用具商品名入力ガイド検索結果,
    /**
     * 境界層該当者情報
     */
    境界層該当者情報,
    /**
     * 境界層措置申請情報
     */
    境界層措置申請情報,
    /**
     * 境界層保険料段階情報
     */
    境界層保険料段階情報,
    /**
     * 賦課エラー一覧
     */
    賦課エラー一覧,
    /**
     * 賦課エラー情報
     */
    賦課エラー情報,
    /**
     * 設定年月
     */
    設定年月,
    /**
     * 調査地区コード
     */
    調査地区コード,
    /**
     * 市町村コード
     */
    市町村コード,
    /**
     * 介護認定審査会委員コード
     */
    介護認定審査会委員コード,
    /**
     * 審査会委員名称
     */
    審査会委員名称,
    /**
     * 償還払決定一覧情報
     */
    償還払決定一覧情報,
    /**
     * 年度
     */
    年度,
    /**
     * 転入保留特定住所一覧情報
     */
    転入保留特定住所一覧情報,
    /**
     * その他機関選択ガイド_モード
     */
    その他機関選択ガイド_モード,
    /**
     * 地区コード
     */
    地区コード,
    /**
     * 地区コード1
     */
    地区コード1,
    /**
     * 地区コード3
     */
    地区コード3,
    /**
     * 地区コード10
     */
    地区コード10,
    /**
     * 画面番号
     */
    画面番号,
    /**
     * 画面ステート
     */
    画面ステート,
    /**
     * 申請書管理番号2
     */
    申請書管理番号2,
    /**
     * 申請書管理番号3
     */
    申請書管理番号3,
    /**
     * 対象者区分
     */
    対象者区分,
    /**
     * 設定日
     */
    設定日,
    /**
     * 保険者
     */
    保険者,
    /**
     * 調査員情報
     */
    調査員情報,
    /**
     * 調査員状況02
     */
    調査員状況02,
    /**
     * 予約可否
     */
    予約可否,
    /**
     * 予約状況
     */
    予約状況,
    /**
     * 遷移元画面番号
     */
    遷移元画面番号,
    /**
     * 時間枠
     */
    時間枠,
    /**
     * 認定調査員コード
     */
    認定調査員コード,
    /**
     * 認定調査スケジュールメモ情報
     */
    認定調査スケジュールメモ情報,
    /**
     * 開催年月日
     */
    開催年月日,
    /**
     * 介護認定審査会割当委員情報
     */
    介護認定審査会割当委員情報_一覧,
    /**
     * 画面番号03
     */
    画面番号03,
    /**
     * 認定調査スケジュール登録_モード
     */
    認定調査スケジュール登録_モード,
    /**
     * 表示モード
     */
    表示モード,
    /**
     * 利用モード
     */
    利用モード,
    /**
     * 明細表示モード。
     */
    明細表示モード,
    /**
     * 選択審査会一覧。
     */
    選択審査会一覧,
    /**
     * 引き継ぎデータ
     */
    引き継ぎデータ,
    /**
     * 事業者施設選択入力ガイド_モード
     */
    事業者施設選択入力ガイド_モード,
    /**
     * 認定調査スケジュール情報
     */
    認定調査スケジュール情報,
    /**
     * 地区認定調査員情報
     */
    地区認定調査員情報,
    /**
     * 認定申請情報
     */
    認定申請情報,
    /**
     * 介護認定審査会開催予定情報
     */
    介護認定審査会開催予定情報,
    /**
     * 主治医意見書作成依頼情報
     */
    主治医意見書作成依頼情報,
    /**
     * 要介護認定申請情報
     */
    要介護認定申請情報,
    /**
     * 意見書情報
     */
    意見書情報,
    /**
     * イメージ情報
     */
    イメージ情報,
    /**
     * 地区市町村情報
     */
    地区市町村情報,
    /**
     * 保険者番号
     */
    保険者番号,
    /**
     * 要介護認定主治医意見書情報
     */
    要介護認定主治医意見書情報,
    /**
     * 一次判定結果_一次判定結果
     */
    一次判定結果,
    /**
     * 一次判定結果_一次判定結果情報
     */
    一次判定結果情報,
    /**
     * 老齢福祉年金情報_老齢福祉年金情報検索結果一覧。
     */
    老齢福祉年金情報検索結果一覧,
    /**
     * 事業者登録情報。
     */
    事業者登録情報,
    /**
     * サービス一覧情報。
     */
    サービス一覧情報,
    /**
     * 事業者登録_画面状態。
     */
    画面状態,
    /**
     * 事業者登録_事業者種類コード。
     */
    事業者種類コード,
    /**
     * 事業者登録_有効開始日。
     */
    有効開始日,
    /**
     * サービス登録_サービス種類コード。
     */
    サービス種類コード,
    /**
     * 他住所地特例。
     */
    他住所地特例,
    /**
     * 保険施設入退所。
     */
    保険施設入退所,
    /**
     * サービス情報。
     */
    サービス情報,
    /**
     * 資格取得除外者一覧。
     */
    資格取得除外者一覧,
    /**
     * 適用除外者情報。
     */
    適用除外者情報,
    /**
     * 被保険者台帳情報。
     */
    被保険者台帳情報,
    /**
     * 資格変更入力。
     */
    資格変更入力,
    /**
     * 介護事業者情報。
     */
    介護事業者情報,
    /**
     * 事業者種別
     */
    事業者種別,
    /**
     * 保険施設入退所情報
     */
    保険施設入退所情報,
    /**
     * 資格得喪情報
     */
    資格得喪情報,
    /**
     * 初期化時医療保険情報
     */
    初期化時医療保険情報,
    /**
     * 初期化時老福年金情報
     */
    初期化時老福年金情報,
    /**
     * 証交付回収情報
     */
    証交付回収情報,
    /**
     * 証交付回収情報_被保番号
     */
    証交付回収情報_被保番号,
    /**
     * 認定調査スケジュール登録10_画面項目。
     */
    認定調査スケジュール登録10_画面項目,
    /**
     * 認定調査スケジュール登録10_対象者をクリアする表示。
     */
    認定調査スケジュール登録10_対象者をクリアする表示,
    /**
     * 認定調査スケジュール登録10_対象者を検索するモード。
     */
    認定調査スケジュール登録10_対象者を検索するモード,
    /**
     * 認定調査スケジュール登録10_対象者を検索。
     */
    認定調査スケジュール登録10_対象者を検索,
    /**
     * 認定調査スケジュール登録10_対象者をクリアする状態。
     */
    認定調査スケジュール登録10_対象者をクリアする状態,
    /**
     * 住宅改修内容一覧_検索結果
     */
    住宅改修内容一覧_検索結果,
    /**
     * 資格喪失異動_識別コード
     */
    資格喪失異動_識別コード,
    /**
     * 資格取得異動_識別コード
     */
    資格取得異動_識別コード,
    /**
     * 資格取得異動_状態_被保履歴タブ
     */
    資格取得異動_状態_被保履歴タブ,
    /**
     * 資格取得異動_状態_医療保険タブ
     */
    資格取得異動_状態_医療保険タブ,
    /**
     * 資格取得異動_状態_老福年金タブ
     */
    資格取得異動_状態_老福年金タブ,
    /**
     * 資格取得異動_状態_施設入退所タブ
     */
    資格取得異動_状態_施設入退所タブ,
    /**
     * 資格喪失異動_状態_被保履歴タブ
     */
    資格喪失異動_状態_被保履歴タブ,
    /**
     * 資格喪失異動_状態_医療保険タブ
     */
    資格喪失異動_状態_医療保険タブ,
    /**
     * 資格喪失異動_状態_老福年金タブ
     */
    資格喪失異動_状態_老福年金タブ,
    /**
     * 資格喪失異動_状態_施設入退所タブ
     */
    資格喪失異動_状態_施設入退所タブ,
    /**
     * 資格喪失異動_状態_証類状況タブ
     */
    資格喪失異動_状態_証類状況タブ,
    /**
     * 要介護認定申請モニタリストフラグ
     */
    要介護認定申請モニタリストフラグ,
    /**
     * 要支援認定等申請者一覧フラグ
     */
    要支援認定等申請者一覧フラグ,
    /**
     * 認定調査予定未定者一覧フラグ
     */
    認定調査予定未定者一覧フラグ,
    /**
     * 認定調査依頼先変更者一覧表フラグ
     */
    認定調査依頼先変更者一覧表フラグ,
    /**
     * 認定調査結果と主治医意見書のチェックリストフラグ
     */
    認定調査結果と主治医意見書のチェックリストフラグ,
    /**
     * 主治医意見書未提出者一覧フラグ
     */
    主治医意見書未提出者一覧フラグ,
    /**
     * 主治医意見書５項目確認一覧表フラグ
     */
    主治医意見書５項目確認一覧表フラグ,
    /**
     * 主治医意見書依頼未処理者一覧表フラグ
     */
    主治医意見書依頼未処理者一覧表フラグ,
    /**
     * 主治医意見書作成依頼変更者一覧表フラグ
     */
    主治医意見書作成依頼変更者一覧表フラグ,
    /**
     * 主治医意見書依頼済み一覧表フラグ
     */
    主治医意見書依頼済み一覧表フラグ,
    /**
     * 主治医意見書作成料請求一覧表フラグ
     */
    主治医意見書作成料請求一覧表フラグ,
    /**
     * 主治医意見書依頼_申請書管理番号List
     */
    申請書管理番号List,
    /**
     * 資格不整合_整合性チェックの情報_宛名
     */
    整合性チェックの情報_宛名,
    /**
     * 整資格不整合_不整合修正中
     */
    不整合修正中,
    /**
     * 整資格不整合_現在の資格の情報
     */
    現在の資格の情報,
    /**
     * 整資格不整合_修正後の資格の情報
     */
    修正後の資格の情報,
    /**
     * 整資格不整合_現在の他特の情報
     */
    現在の他特の情報,
    /**
     * 整資格不整合_修正後の他特の情報
     */
    修正後の他特の情報,
    /**
     * 整資格不整合_現在の除外の情報
     */
    現在の除外の情報,
    /**
     * 整資格不整合_修正後の除外の情報
     */
    修正後の除外の情報,
    /**
     * 整資格不整合_不整合理由
     */
    不整合理由,
    /**
     * 整資格不整合_台帳状態
     */
    台帳状態,
    /**
     * 整資格不整合_個人情報
     */
    個人情報,
    /**
     * 整資格不整合_取得除外の情報
     */
    取得除外の情報,
    /**
     * 帳票制御共通
     */
    帳票制御共通,
    /**
     * その他機関マスタ検索結果
     */
    その他機関マスタ検索結果,
    /**
     * 初期の概況特記
     */
    初期の概況特記,
    /**
     * 基本調査の入力状況
     */
    基本調査の入力状況,
    /**
     * 再調査の場合
     */
    再調査の場合,
    /**
     * 初期の予防給付サービス
     */
    初期の予防給付サービス,
    /**
     * 初期の介護給付サービス
     */
    初期の介護給付サービス,
    /**
     * 住宅改修rad
     */
    住宅改修rad,
    /**
     * 市町村特別給付TXT
     */
    市町村特別給付TXT,
    /**
     * 介護保険給付以外の在宅サービスTXT
     */
    介護保険給付以外の在宅サービスTXT,
    /**
     * 初期の施設利用
     */
    初期の施設利用,
    /**
     * 初期の施設連絡先
     */
    初期の施設連絡先,
    /**
     * 特記
     */
    特記,
    /**
     * 初期の基本調査
     */
    初期の基本調査,
    /**
     * 厚労省IF識別コード
     */
    厚労省IF識別コード,
    /**
     * 認定調査依頼区分コード
     */
    認定調査依頼区分コード,
    /**
     * 認定調査回数
     */
    認定調査回数,
    /**
     * 初期のサービス区分
     */
    初期のサービス区分,
    /**
     * 現在のサービス区分
     */
    現在のサービス区分,
    /**
     * 現在の概況調査場所（在宅/施設）
     */
    現在の概況調査場所,
    /**
     * 初期の概況調査場所（在宅/施設）
     */
    初期の概況調査場所,
    /**
     * 調査実施場所コード
     */
    調査実施場所コード,
    /**
     * 前回基本調査項目値あり
     */
    前回基本調査項目値あり,
    /**
     * 保険料段階を全件
     */
    保険料段階を全件,
    /**
     * 保険料段階DATESOURCE
     */
    保険料段階DATESOURCE,
    /**
     * 該当者一覧キー
     */
    該当者一覧キー,
    /**
     * ラジオ_指定
     */
    ラジオ_指定,
    /**
     * 被保険者名
     */
    被保険者名,
    /**
     * サービス提供年月From
     */
    サービス提供年月From,
    /**
     * サービス提供年月To
     */
    サービス提供年月To,
    /**
     * 申請年月From
     */
    申請年月From,
    /**
     * 申請年月To
     */
    申請年月To,
    /**
     * 決定年月From
     */
    決定年月From,
    /**
     * 決定年月To
     */
    決定年月To,
    /**
     * 申請年月
     */
    申請年月,
    /**
     * 決定年月
     */
    決定年月,
    /**
     * 検索キー
     */
    検索キー,
    /**
     * 最大件数
     */
    最大件数,
    /**
     * 処理モード
     */
    処理モード,
    /**
     * 一覧データ
     */
    一覧データ,
    /**
     * 詳細データ
     */
    詳細データ,
    /**
     * 契約事業者番号
     */
    契約事業者番号,
    /**
     * 契約事業者名
     */
    契約事業者名,
    /**
     * 画面モード
     */
    画面モード,
    /**
     * 契約者一覧情報
     */
    契約者一覧情報,
    /**
     * 契約者詳細データ
     */
    契約者詳細データ,
    /**
     * 処理年月
     */
    処理年月,
    /**
     * 証明書
     */
    証明書,
    /**
     * 福祉償還払請求基本
     */
    福祉償還払請求基本,
    /**
     * 福祉用具販売費
     */
    福祉用具販売費,
    /**
     * 福祉償還払支給申請
     */
    福祉償還払支給申請,
    /**
     * 福祉償還払請求集計
     */
    福祉償還払請求集計,
    /**
     * 給付率
     */
    給付率,
    /**
     * 償還払支給判定結果
     */
    償還払支給判定結果,
    /**
     * 明細データ
     */
    明細データ,
    /**
     * 登録用決定情報
     */
    登録用決定情報,
    /**
     * 支給申請日TO
     */
    支給申請日TO,
    /**
     * 支給申請日FROM
     */
    支給申請日FROM,
    /**
     * 福祉審査決定
     */
    福祉審査決定,
    /**
     * 償還払支給住宅改修事前申請情報
     */
    償還払支給住宅改修事前申請情報,
    /**
     * 住宅改修データ
     */
    住宅改修データ,
    /**
     * 前回までの支払結果
     */
    前回までの支払結果,
    /**
     * 限度額リセット値
     */
    限度額リセット値,
    /**
     * 申請情報
     */
    申請情報,
    /**
     * 申請一覧
     */
    申請一覧,
    /**
     * 画面データ
     */
    画面データ,
    /**
     * 口座情報
     */
    口座情報,
    /**
     * 明細検索キー
     */
    明細検索キー,
    /**
     * 申請検索キー
     */
    申請検索キー,
    /**
     * 識別番号検索キー
     */
    識別番号検索キー,
    /**
     * 前回支払金額
     */
    前回支払金額,
    /**
     * 様式番号List
     */
    様式番号List,
    /**
     * 申請年月日
     */
    申請年月日,
    /**
     * 給付費明細登録
     */
    給付費明細登録,
    /**
     * 基本データ
     */
    基本データ,
    /**
     * 償還払請求特定診療費データ
     */
    償還払請求特定診療費データ,
    /**
     * サービス計画費データ
     */
    サービス計画費データ,
    /**
     * 特別療養費一覧
     */
    特別療養費一覧,
    /**
     * 緊急時施設療養
     */
    緊急時施設療養,
    /**
     * サービス費用データ
     */
    サービス費用データ,
    /**
     * 所定疾患施設療養費等データ
     */
    所定疾患施設療養費等データ,
    /**
     * 食事費用データ
     */
    食事費用データ,
    /**
     * 償還払請求食事費用
     */
    償還払請求食事費用,
    /**
     * 請求額集計一覧情報
     */
    請求額集計一覧情報,
    /**
     * サービス種類集計情報
     */
    サービス種類集計情報,
    /**
     * 給付費明細住特
     */
    給付費明細住特,
    /**
     * 市町村判定
     */
    市町村判定,
    /**
     * メニューID
     */
    メニューID,
    /**
     * 一覧検索キー
     */
    一覧検索キー,
    /**
     * 導入形態コード
     */
    導入形態コード,
    /**
     * 退避用データ
     */
    退避用データ,
    /**
     * 基本情報パラメータ
     */
    基本情報パラメータ,
    /**
     * キーが「発行日時Map」であることを表します
     */
    発行日時Map,
    /**
     * キーが「異動者一覧データ」であることを表します
     */
    異動者一覧データ,
    /**
     * キーが「異動者一覧Par」であることを表します
     */
    異動者一覧Par,
    /**
     * キーが「調定年度」であることを表します
     */
    調定年度,
    /**
     * キーが「賦課年度」であることを表します
     */
    賦課年度,
    /**
     * キーが「通知書番号」であることを表します
     */
    通知書番号,
    /**
     * キーが「打分け方法情報キー」であることを表します
     */
    打分け方法情報キー,
    /**
     * キーが「賦課の情報リスト」であることを表します
     */
    賦課の情報リスト,
    /**
     * 徴収方法データ
     */
    徴収方法データ,
    /**
     * 特別徴収停止日時
     */
    特別徴収停止日時,
    /**
     * 特別徴収停止事由コード
     */
    特別徴収停止事由コード,
    /**
     * キーが「調定日時リスト」であることを表します
     */
    調定日時リスト,
    /**
     * キーが「発行する帳票リスト」であることを表します
     */
    発行する帳票リスト,
    /**
     * キーが「変更通知書帳票略称」であることを表します
     */
    変更通知書帳票略称,
    /**
     * キーが「減免通知書帳票略称」であることを表します
     */
    減免通知書帳票略称,
    /**
     * キーが「徴収猶予通知書帳票略称」であることを表します
     */
    徴収猶予通知書帳票略称,
    /**
     * キーが「処理日付管理」であることを表します
     */
    処理日付管理,
    /**
     * キーが「各種通知書作成フラグ」であることを表します
     */
    各種通知書作成フラグ,
    /**
     * キーが「各種通知書作成戻るフラグ」であることを表します
     */
    各種通知書作成戻るフラグ,
    /**
     * 帳票制御汎用リスト
     */
    帳票制御汎用リスト,
    /**
     * 実行フラグ
     */
    実行フラグ,
    /**
     * 所得照会状況一覧KEY
     */
    所得照会状況一覧KEY,
    /**
     * 特徴送付情報作成FLAG
     */
    特徴送付情報作成FLAG,
    /**
     * 特徴対象者同定実行FLAG
     */
    特徴対象者同定実行FLAG,
    /**
     * 特徴対象者同定STATE
     */
    特徴対象者同定STATE,
    /**
     * 第1号被保険者数情報
     */
    第1号被保険者数情報,
    /**
     * 第1号被保険者増減内訳情報_当月中増
     */
    第1号被保険者増減内訳情報_当月中増,
    /**
     * 第1号被保険者増減内訳情報_当月中滅
     */
    第1号被保険者増減内訳情報_当月中滅,
    /**
     * 報告年月
     */
    報告年月,
    /**
     * 集計年月
     */
    集計年月,
    /**
     * 様式種類コード
     */
    様式種類コード,
    /**
     * 保険者コード
     */
    保険者コード,
    /**
     * 事業報告基本
     */
    事業報告基本,
    /**
     * 事業報告明細
     */
    事業報告明細,
    /**
     * 利用者負担第四段階
     */
    利用者負担第四段階,
    /**
     * 利用者負担第三段階
     */
    利用者負担第三段階,
    /**
     * 利用者負担第二段階
     */
    利用者負担第二段階,
    /**
     * 利用者負担第一段階
     */
    利用者負担第一段階,
    /**
     * 高額介護_合計
     */
    高額介護_合計,
    /**
     * 再掲利用者負担第三段階
     */
    再掲利用者負担第三段階,
    /**
     * 再掲利用者負担第二段階
     */
    再掲利用者負担第二段階,
    /**
     * 現役並み所得者
     */
    現役並み所得者,
    /**
     * 一般
     */
    一般,
    /**
     * 低所得者Ⅱ
     */
    低所得者Ⅱ,
    /**
     * 低所得者Ⅰ
     */
    低所得者Ⅰ,
    /**
     * 高額医療合算介護_合計
     */
    高額医療合算介護_合計,
    /**
     * 様式種類_11
     */
    様式種類_11,
    /**
     * 様式種類_12
     */
    様式種類_12,
    /**
     * 様式種類_21
     */
    様式種類_21,
    /**
     * 様式種類_22
     */
    様式種類_22,
    /**
     * 様式種類_31
     */
    様式種類_31,
    /**
     * 様式種類_32
     */
    様式種類_32,
    /**
     * 様式種類_41
     */
    様式種類_41,
    /**
     * 食費_居住費データリスト
     */
    食費_居住費データリスト,
    /**
     * 利用者負担滅額データリスト
     */
    利用者負担滅額データリスト,
    /**
     * 特定負担限度額データリスト
     */
    特定負担限度額データリスト,
    /**
     * 利用者負担データリスト
     */
    利用者負担データリスト,
    /**
     * 要介護データリスト
     */
    要介護データリスト,
    /**
     * 居宅介護データリスト
     */
    居宅介護データリスト,
    /**
     * 地域密着型データリスト
     */
    地域密着型データリスト,
    /**
     * 施設介護1データリスト
     */
    施設介護1データリスト,
    /**
     * 施設介護2データリスト
     */
    施設介護2データリスト,
    /**
     * 施設介護3データリスト
     */
    施設介護3データリスト,
    /**
     * 社福軽減額一覧情報
     */
    社福軽減額一覧情報,
    /**
     * 市町村Entiyリスト
     */
    市町村Entiyリスト,
    /**
     * キーが「主治医意見書作成報酬実績情報」であることを表します。
     */
    主治医意見書作成報酬実績情報,
    /**
     * 事業報告基本_リスト
     */
    事業報告基本_リスト,
    /**
     * 事業報告基本_リスト
     */
    業報告統計データ_リスト,
    /**
     * 様式１の４業報告統計データ_リスト
     */
    様式１の４業報告統計データ_リスト,
    /**
     * 様式２の５業報告統計データ_リスト
     */
    様式２の５業報告統計データ_リスト,
    /**
     * 件数引き継ぎデータ
     */
    件数引き継ぎデータ,
    /**
     * 単位数引き継ぎデータ
     */
    単位数引き継ぎデータ,
    /**
     * 費用額引き継ぎデータ
     */
    費用額引き継ぎデータ,
    /**
     * 給付額引き継ぎデータ
     */
    給付額引き継ぎデータ,
    /**
     * 年度分賦課減免リスト
     */
    年度分賦課減免リスト,
    /**
     * 年度分賦課減免リスト
     */
    徴収方法,
    /**
     * 滞納判定結果
     */
    滞納判定結果,
    /**
     * 特別徴収開始月
     */
    特別徴収開始月,
    /**
     * 最大表示件数
     */
    最大表示件数,
    /**
     * 処理年度
     */
    処理年度,
    /**
     * 捕捉月
     */
    捕捉月,
    /**
     * 基礎年金番号
     */
    基礎年金番号,
    /**
     * 年金コード
     */
    年金コード,
    /**
     * 確認済を含む
     */
    確認済を含む,
    /**
     * 表示対象
     */
    表示対象,
    /**
     * 確認状況
     */
    確認状況,
    /**
     * 氏名
     */
    氏名,
    /**
     * 捕捉月リスト
     */
    捕捉月リスト;
}
