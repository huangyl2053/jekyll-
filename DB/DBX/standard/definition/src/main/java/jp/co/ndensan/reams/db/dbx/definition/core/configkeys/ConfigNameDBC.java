/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ名称(DBC)を表す列挙型です。
 *
 * @reamsid_L DBX-9999-023 liangbc
 */
public enum ConfigNameDBC {

    /**
     * 国保_後期高齢ＩＦ_国保Ｆ
     */
    国保_後期高齢ＩＦ_国保Ｆ("国保_後期高齢ＩＦ_国保Ｆ"),
    /**
     * 国保_後期高齢ＩＦ_後期Ｆ
     */
    国保_後期高齢ＩＦ_後期Ｆ("国保_後期高齢ＩＦ_後期Ｆ"),
    /**
     * 国保_後期高齢ＩＦ_国保格納場所
     */
    国保_後期高齢ＩＦ_国保格納場所("国保_後期高齢ＩＦ_国保格納場所"),
    /**
     * 国保_後期高齢ＩＦ_国保全件差分区分
     */
    国保_後期高齢ＩＦ_国保全件差分区分("国保_後期高齢ＩＦ_国保全件差分区分"),
    /**
     * 国保_後期高齢ＩＦ_後期全件差分区分
     */
    国保_後期高齢ＩＦ_後期全件差分区分("国保_後期高齢ＩＦ_後期全件差分区分"),
    /**
     * 国保連共同処理受託区分_事業高額
     */
    国保連共同処理受託区分_事業高額("国保連共同処理受託区分_事業高額"),
    /**
     * 国保連共同処理受託区分_高額
     */
    国保連共同処理受託区分_高額("国保連共同処理受託区分_高額"),
    /**
     * 高額決定通知書_支払方法抽出区分
     */
    高額決定通知書_支払方法抽出区分("高額決定通知書_支払方法抽出区分"),
    /**
     * 高額決定通知書_帳票ID
     */
    高額決定通知書_帳票ID("高額決定通知書_帳票ID"),
    /**
     * 事業高額決定通知書_帳票ID
     */
    事業高額決定通知書_帳票ID("事業高額決定通知書_帳票ID"),
    /**
     * 初期表示_給付率。
     */
    初期表示_給付率("初期表示_償還支給申請登録初期"),
    /**
     * 償還支給申請書_審査方法初期表示。
     */
    償還支給申請書_審査方法初期表示("償還支給申請書_審査方法初期表示"),
    /**
     * 初期表示_償還支給申請登録初期。
     */
    初期表示_償還支給申請登録初期("初期表示_償還支給申請登録初期"),
    /**
     * 第1段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第1段階_高額介護サービス費支給_201504以降_自己負担上限月額("第1段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第1段階_高額介護サービス費支給_自己負担上限月額
     */
    第1段階_高額介護サービス費支給_自己負担上限月額("第1段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第2段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第2段階_高額介護サービス費支給_201504以降_自己負担上限月額("第2段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第2段階_高額介護サービス費支給_自己負担上限月額
     */
    第2段階_高額介護サービス費支給_自己負担上限月額("第2段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第3段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第3段階_高額介護サービス費支給_201504以降_自己負担上限月額("第3段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第3段階_高額介護サービス費支給_自己負担上限月額
     */
    第3段階_高額介護サービス費支給_自己負担上限月額("第3段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第4段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第4段階_高額介護サービス費支給_201504以降_自己負担上限月額("第4段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 国保連共同処理受託区分_償還
     */
    国保連共同処理受託区分_償還("国保連共同処理受託区分_償還"),
    /**
     * 国保連取込_取込ファイル_保管日数
     */
    国保連取込_取込ファイル_保管日数("国保連取込_取込ファイル_保管日数"),
    /**
     * 国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号
     */
    国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号("国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号
     */
    国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号("国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_償還払支給決定者一覧情報_交換情報識別番号
     */
    国保連取込_償還払支給決定者一覧情報_交換情報識別番号("国保連取込_償還払支給決定者一覧情報_交換情報識別番号"),
    /**
     * 国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号
     */
    国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号(
            "国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_高額介護サービス費支給不支給決定者一覧表情報_交換情報識別番号
     */
    国保連取込_高額介護サービス費支給不支給決定者一覧表情報_交換情報識別番号(
            "国保連取込_高額介護サービス費支給不支給決定者一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号
     */
    国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号(
            "国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_受給者情報更新結果情報_交換情報識別番号
     */
    国保連取込_受給者情報更新結果情報_交換情報識別番号("国保連取込_受給者情報更新結果情報_交換情報識別番号"),
    /**
     * 国保連取込_共同処理用受給者情報更新結果_交換情報識別番号
     */
    国保連取込_共同処理用受給者情報更新結果_交換情報識別番号("国保連取込_共同処理用受給者情報更新結果_交換情報識別番号"),
    /**
     * 国保連取込_給付実績情報_交換情報識別番号
     */
    国保連取込_給付実績情報_交換情報識別番号("国保連取込_給付実績情報_交換情報識別番号"),
    /**
     * 国保連取込_給付管理票情報_交換情報識別番号
     */
    国保連取込_給付管理票情報_交換情報識別番号("国保連取込_給付管理票情報_交換情報識別番号"),
    /**
     * 国保連取込_給付実績更新結果情報_交換情報識別番号
     */
    国保連取込_給付実績更新結果情報_交換情報識別番号("国保連取込_給付実績更新結果情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費等審査決定請求明細表情報_交換情報識別番号
     */
    国保連取込_介護給付費等審査決定請求明細表情報_交換情報識別番号("国保連取込_介護給付費等審査決定請求明細表情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費再審査決定通知書情報_交換情報識別番号
     */
    国保連取込_介護給付費再審査決定通知書情報_交換情報識別番号("国保連取込_介護給付費再審査決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費等請求額通知書情報_交換情報識別番号
     */
    国保連取込_介護給付費等請求額通知書情報_交換情報識別番号("国保連取込_介護給付費等請求額通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号
     */
    国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号("国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費公費受給者別一覧表情報_交換情報識別番号
     */
    国保連取込_介護給付費公費受給者別一覧表情報_交換情報識別番号("国保連取込_介護給付費公費受給者別一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_償還払不支給決定者一覧情報_交換情報識別番号
     */
    国保連取込_償還払不支給決定者一覧情報_交換情報識別番号("国保連取込_償還払不支給決定者一覧情報_交換情報識別番号"),
    /**
     * 国保連取込_受給者台帳情報一覧_交換情報識別番号
     */
    国保連取込_受給者台帳情報一覧_交換情報識別番号("国保連取込_受給者台帳情報一覧_交換情報識別番号"),
    /**
     * 国保連取込_受給者台帳突合結果情報随時_交換情報識別番号
     */
    国保連取込_受給者台帳突合結果情報随時_交換情報識別番号("国保連取込_受給者台帳突合結果情報随時_交換情報識別番号"),
    /**
     * 国保連取込_共同処理用受給者情報一覧_交換情報識別番号
     */
    国保連取込_共同処理用受給者情報一覧_交換情報識別番号("国保連取込_共同処理用受給者情報一覧_交換情報識別番号"),
    /**
     * 国保連取込_高額合算自己負担額確認情報_交換情報識別番号
     */
    国保連取込_高額合算自己負担額確認情報_交換情報識別番号("国保連取込_高額合算自己負担額確認情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算自己負担額証明書情報_交換情報識別番号
     */
    国保連取込_高額合算自己負担額証明書情報_交換情報識別番号("国保連取込_高額合算自己負担額証明書情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号
     */
    国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号("国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号
     */
    国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号("国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算給付実績情報_交換情報識別番号
     */
    国保連取込_高額合算給付実績情報_交換情報識別番号("国保連取込_高額合算給付実績情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置過誤決定通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置過誤決定通知書情報_交換情報識別番号(
            "国保連取込_総合事業費経過措置過誤決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号(
            "国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置審査決定請求明細表情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置審査決定請求明細表情報_交換情報識別番号(
            "国保連取込_総合事業費経過措置審査決定請求明細表情報_交換情報識別番号"),
    /**
     * 国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号(
            "国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_資格照合表情報_交換情報識別番号
     */
    国保連取込_資格照合表情報_交換情報識別番号("国保連取込_資格照合表情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置資格照合表情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置資格照合表情報_交換情報識別番号("国保連取込_総合事業費経過措置資格照合表情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費過誤決定通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費過誤決定通知書情報_交換情報識別番号("国保連取込_総合事業費過誤決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費再審査決定通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費再審査決定通知書情報_交換情報識別番号("国保連取込_総合事業費再審査決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費過誤決定通知書公費情報_交換情報識別番号
     */
    国保連取込_総合事業費過誤決定通知書公費情報_交換情報識別番号("国保連取込_総合事業費過誤決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号
     */
    国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号("国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費資格照合表情報_交換情報識別番号
     */
    国保連取込_総合事業費資格照合表情報_交換情報識別番号("国保連取込_総合事業費資格照合表情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費等請求額通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費等請求額通知書情報_交換情報識別番号("国保連取込_総合事業費等請求額通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号
     */
    国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号("国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費審査決定請求明細表情報_交換情報識別番号
     */
    国保連取込_総合事業費審査決定請求明細表情報_交換情報識別番号("国保連取込_総合事業費審査決定請求明細表情報_交換情報識別番号"),
    /**
     * 国保連送付_受給者異動連絡票情報_交換情報識別番号
     */
    国保連送付_受給者異動連絡票情報_交換情報識別番号("国保連送付_受給者異動連絡票情報_交換情報識別番号"),
    /**
     * 国保連送付_共同処理用受給者異動情報_交換情報識別番号
     */
    国保連送付_共同処理用受給者異動情報_交換情報識別番号("国保連送付_共同処理用受給者異動情報_交換情報識別番号"),
    /**
     * 国保連送付_給付管理票_交換情報識別番号
     */
    国保連送付_給付管理票_交換情報識別番号("国保連送付_給付管理票_交換情報識別番号"),
    /**
     * 国保連送付_償還連絡票情報_交換情報識別番号
     */
    国保連送付_償還連絡票情報_交換情報識別番号("国保連送付_償還連絡票情報_交換情報識別番号"),
    /**
     * 国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号
     */
    国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号("国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号"),
    /**
     * 国保連送付_給付実績情報_交換情報識別番号
     */
    国保連送付_給付実績情報_交換情報識別番号("国保連送付_給付実績情報_交換情報識別番号"),
    /**
     * 国保連送付_過誤申立書情報_交換情報識別番号
     */
    国保連送付_過誤申立書情報_交換情報識別番号("国保連送付_過誤申立書情報_交換情報識別番号"),
    /**
     * 国保連送付_再審査申立書情報_交換情報識別番号
     */
    国保連送付_再審査申立書情報_交換情報識別番号("国保連送付_再審査申立書情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算支給申請書情報_交換情報識別番号
     */
    国保連送付_高額合算支給申請書情報_交換情報識別番号("国保連送付_高額合算支給申請書情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算補正済自己負担額情報_交換情報識別番号
     */
    国保連送付_高額合算補正済自己負担額情報_交換情報識別番号("国保連送付_高額合算補正済自己負担額情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算計算結果連絡票情報_交換情報識別番号
     */
    国保連送付_高額合算計算結果連絡票情報_交換情報識別番号("国保連送付_高額合算計算結果連絡票情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算給付実績情報_交換情報識別番号
     */
    国保連送付_高額合算給付実績情報_交換情報識別番号("国保連送付_高額合算給付実績情報_交換情報識別番号"),
    /**
     * 国保連送付_総合事業費過誤申立書情報_交換情報識別番号
     */
    国保連送付_総合事業費過誤申立書情報_交換情報識別番号("国保連送付_総合事業費過誤申立書情報_交換情報識別番号"),
    /**
     * 国保連送付_総合事業分サービスコード異動連絡票情報_交換情報識別番号
     */
    国保連送付_総合事業分サービスコード異動連絡票情報_交換情報識別番号("国保連送付_総合事業分サービスコード異動連絡票情報_交換情報識別番号"),
    /**
     * 国保連取込媒体_過誤決定Ｆ_交換情報識別番号
     */
    国保連取込媒体_過誤決定Ｆ_交換情報識別番号("国保連取込媒体_過誤決定Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_過誤決定公費Ｆ_交換情報識別番号
     */
    国保連取込媒体_過誤決定公費Ｆ_交換情報識別番号("国保連取込媒体_過誤決定公費Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_給付管理Ｆ_交換情報識別番号
     */
    国保連取込媒体_給付管理Ｆ_交換情報識別番号("国保連取込媒体_給付管理Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_給付実績Ｆ_交換情報識別番号
     */
    国保連取込媒体_給付実績Ｆ_交換情報識別番号("国保連取込媒体_給付実績Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_給付実績結果Ｆ_交換情報識別番号
     */
    国保連取込媒体_給付実績結果Ｆ_交換情報識別番号("国保連取込媒体_給付実績結果Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_共同更新Ｆ_交換情報識別番号
     */
    国保連取込媒体_共同更新Ｆ_交換情報識別番号("国保連取込媒体_共同更新Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_共同受給Ｆ_交換情報識別番号
     */
    国保連取込媒体_共同受給Ｆ_交換情報識別番号("国保連取込媒体_共同受給Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_公費一覧Ｆ_交換情報識別番号
     */
    国保連取込媒体_公費一覧Ｆ_交換情報識別番号("国保連取込媒体_公費一覧Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_高額決定者Ｆ_交換情報識別番号
     */
    国保連取込媒体_高額決定者Ｆ_交換情報識別番号("国保連取込媒体_高額決定者Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_高額対象者Ｆ_交換情報識別番号
     */
    国保連取込媒体_高額対象者Ｆ_交換情報識別番号("国保連取込媒体_高額対象者Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_再審決定Ｆ_交換情報識別番号
     */
    国保連取込媒体_再審決定Ｆ_交換情報識別番号("国保連取込媒体_再審決定Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_再審決定公費Ｆ_交換情報識別番号
     */
    国保連取込媒体_再審決定公費Ｆ_交換情報識別番号("国保連取込媒体_再審決定公費Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_受給更新Ｆ_交換情報識別番号
     */
    国保連取込媒体_受給更新Ｆ_交換情報識別番号("国保連取込媒体_受給更新Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_受給台帳Ｆ_交換情報識別番号
     */
    国保連取込媒体_受給台帳Ｆ_交換情報識別番号("国保連取込媒体_受給台帳Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_受給突合結果Ｆ_交換情報識別番号
     */
    国保連取込媒体_受給突合結果Ｆ_交換情報識別番号("国保連取込媒体_受給突合結果Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_償還支給Ｆ_交換情報識別番号
     */
    国保連取込媒体_償還支給Ｆ_交換情報識別番号("国保連取込媒体_償還支給Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_償還不支給Ｆ_交換情報識別番号
     */
    国保連取込媒体_償還不支給Ｆ_交換情報識別番号("国保連取込媒体_償還不支給Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_審査請求Ｆ_交換情報識別番号
     */
    国保連取込媒体_審査請求Ｆ_交換情報識別番号("国保連取込媒体_審査請求Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_請求通知Ｆ_交換情報識別番号
     */
    国保連取込媒体_請求通知Ｆ_交換情報識別番号("国保連取込媒体_請求通知Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_請求通知公費Ｆ_交換情報識別番号
     */
    国保連取込媒体_請求通知公費Ｆ_交換情報識別番号("国保連取込媒体_請求通知公費Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_自己負担確認Ｆ_交換情報識別番号
     */
    国保連取込媒体_自己負担確認Ｆ_交換情報識別番号("国保連取込媒体_自己負担確認Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_自己負担証明Ｆ_交換情報識別番号
     */
    国保連取込媒体_自己負担証明Ｆ_交換情報識別番号("国保連取込媒体_自己負担証明Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_支給計算結果Ｆ_交換情報識別番号
     */
    国保連取込媒体_支給計算結果Ｆ_交換情報識別番号("国保連取込媒体_支給計算結果Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_合算支給通知Ｆ_交換情報識別番号
     */
    国保連取込媒体_合算支給通知Ｆ_交換情報識別番号("国保連取込媒体_合算支給通知Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号
     */
    国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号("国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_合算給付実績Ｆ_交換情報識別番号
     */
    国保連取込媒体_合算給付実績Ｆ_交換情報識別番号("国保連取込媒体_合算給付実績Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_過誤決定総合Ｆ_交換情報識別番号
     */
    国保連取込媒体_過誤決定総合Ｆ_交換情報識別番号("国保連取込媒体_過誤決定総合Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_請求通知総合Ｆ_交換情報識別番号
     */
    国保連取込媒体_請求通知総合Ｆ_交換情報識別番号("国保連取込媒体_請求通知総合Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_審査請求総合Ｆ_交換情報識別番号
     */
    国保連取込媒体_審査請求総合Ｆ_交換情報識別番号("国保連取込媒体_審査請求総合Ｆ_交換情報識別番号"),
    /**
     * 国保連取込_受給者情報突合結果情報_交換情報識別番号
     */
    国保連取込_受給者情報突合結果情報_交換情報識別番号("国保連取込_受給者情報突合結果情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費公費受給者別一覧表_交換情報識別番号
     */
    国保連取込_総合事業費公費受給者別一覧表_交換情報識別番号("国保連取込_総合事業費公費受給者別一覧表_交換情報識別番号"),
    /**
     * 償還払支給不支給決定通知書一括作成_初期選択抽出条件
     */
    償還払支給不支給決定通知書一括作成_初期選択抽出条件("償還払支給不支給決定通知書一括作成_初期選択抽出条件"),
    /**
     * 利用者負担割合判定基準_本人未申告区分
     */
    利用者負担割合判定基準_本人未申告区分("利用者負担割合判定基準_本人未申告区分"),
    /**
     * 利用者負担割合判定基準_本人所得調査中区分
     */
    利用者負担割合判定基準_本人所得調査中区分("利用者負担割合判定基準_本人所得調査中区分"),
    /**
     * 利用者負担割合判定基準_本人合計所得金額基準
     */
    利用者負担割合判定基準_本人合計所得金額基準("利用者負担割合判定基準_本人合計所得金額基準"),
    /**
     * 利用者負担割合判定基準_世帯年金収入等基準単身
     */
    利用者負担割合判定基準_世帯年金収入等基準単身("利用者負担割合判定基準_世帯年金収入等基準単身"),
    /**
     * 利用者負担割合判定基準_世帯年金収入等基準複数
     */
    利用者負担割合判定基準_世帯年金収入等基準複数("利用者負担割合判定基準_世帯年金収入等基準複数"),
    /**
     * 利用者負担割合判定管理_年次負担割合処理済年度
     */
    利用者負担割合判定管理_年次負担割合処理済年度("利用者負担割合判定管理_年次負担割合処理済年度"),
    /**
     * 利用者負担割合判定管理_年次負担割合処理状態
     */
    利用者負担割合判定管理_年次負担割合処理状態("利用者負担割合判定管理_年次負担割合処理状態"),
    /**
     * 国保連取込媒体_過誤決定Ｆ_ファイル名称
     */
    国保連取込媒体_過誤決定Ｆ_ファイル名称("国保連取込媒体_過誤決定Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_過誤決定公費Ｆ_ファイル名称
     */
    国保連取込媒体_過誤決定公費Ｆ_ファイル名称("国保連取込媒体_過誤決定公費Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_給付管理Ｆ_ファイル名称
     */
    国保連取込媒体_給付管理Ｆ_ファイル名称("国保連取込媒体_給付管理Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_給付実績Ｆ_ファイル名称
     */
    国保連取込媒体_給付実績Ｆ_ファイル名称("国保連取込媒体_給付実績Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_給付実績結果Ｆ_ファイル名称
     */
    国保連取込媒体_給付実績結果Ｆ_ファイル名称("国保連取込媒体_給付実績結果Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_共同更新Ｆ_ファイル名称
     */
    国保連取込媒体_共同更新Ｆ_ファイル名称("国保連取込媒体_共同更新Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_共同受給Ｆ_ファイル名称
     */
    国保連取込媒体_共同受給Ｆ_ファイル名称("国保連取込媒体_共同受給Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_公費一覧Ｆ_ファイル名称
     */
    国保連取込媒体_公費一覧Ｆ_ファイル名称("国保連取込媒体_公費一覧Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_高額決定者Ｆ_ファイル名称
     */
    国保連取込媒体_高額決定者Ｆ_ファイル名称("国保連取込媒体_高額決定者Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_高額対象者Ｆ_ファイル名称
     */
    国保連取込媒体_高額対象者Ｆ_ファイル名称("国保連取込媒体_高額対象者Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_再審決定Ｆ_ファイル名称
     */
    国保連取込媒体_再審決定Ｆ_ファイル名称("国保連取込媒体_再審決定Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_再審決定公費Ｆ_ファイル名称
     */
    国保連取込媒体_再審決定公費Ｆ_ファイル名称("国保連取込媒体_再審決定公費Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_受給更新Ｆ_ファイル名称
     */
    国保連取込媒体_受給更新Ｆ_ファイル名称("国保連取込媒体_受給更新Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_受給台帳Ｆ_ファイル名称
     */
    国保連取込媒体_受給台帳Ｆ_ファイル名称("国保連取込媒体_受給台帳Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_受給突合結果Ｆ_ファイル名称
     */
    国保連取込媒体_受給突合結果Ｆ_ファイル名称("国保連取込媒体_受給突合結果Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_償還支給Ｆ_ファイル名称
     */
    国保連取込媒体_償還支給Ｆ_ファイル名称("国保連取込媒体_償還支給Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_償還不支給Ｆ_ファイル名称
     */
    国保連取込媒体_償還不支給Ｆ_ファイル名称("国保連取込媒体_償還不支給Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_審査請求Ｆ_ファイル名称
     */
    国保連取込媒体_審査請求Ｆ_ファイル名称("国保連取込媒体_審査請求Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_請求通知Ｆ_ファイル名称
     */
    国保連取込媒体_請求通知Ｆ_ファイル名称("国保連取込媒体_請求通知Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_請求通知公費Ｆ_ファイル名称
     */
    国保連取込媒体_請求通知公費Ｆ_ファイル名称("国保連取込媒体_請求通知公費Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_自己負担確認Ｆ_ファイル名称
     */
    国保連取込媒体_自己負担確認Ｆ_ファイル名称("国保連取込媒体_自己負担確認Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_自己負担証明Ｆ_ファイル名称
     */
    国保連取込媒体_自己負担証明Ｆ_ファイル名称("国保連取込媒体_自己負担証明Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_支給計算結果Ｆ_ファイル名称
     */
    国保連取込媒体_支給計算結果Ｆ_ファイル名称("国保連取込媒体_支給計算結果Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_合算支給通知Ｆ_ファイル名称
     */
    国保連取込媒体_合算支給通知Ｆ_ファイル名称("国保連取込媒体_合算支給通知Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_合算支給一覧Ｆ_ファイル名称
     */
    国保連取込媒体_合算支給一覧Ｆ_ファイル名称("国保連取込媒体_合算支給一覧Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_合算給付実績Ｆ_ファイル名称
     */
    国保連取込媒体_合算給付実績Ｆ_ファイル名称("国保連取込媒体_合算給付実績Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_過誤決定総合Ｆ_ファイル名称
     */
    国保連取込媒体_過誤決定総合Ｆ_ファイル名称("国保連取込媒体_過誤決定総合Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_請求通知総合Ｆ_ファイル名称
     */
    国保連取込媒体_請求通知総合Ｆ_ファイル名称("国保連取込媒体_請求通知総合Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_審査請求総合Ｆ_ファイル名称
     */
    国保連取込媒体_審査請求総合Ｆ_ファイル名称("国保連取込媒体_審査請求総合Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_過誤決定Ｆ_媒体区分
     */
    国保連取込媒体_過誤決定Ｆ_媒体区分("国保連取込媒体_過誤決定Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_過誤決定公費Ｆ_媒体区分
     */
    国保連取込媒体_過誤決定公費Ｆ_媒体区分("国保連取込媒体_過誤決定公費Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_給付管理Ｆ_媒体区分
     */
    国保連取込媒体_給付管理Ｆ_媒体区分("国保連取込媒体_給付管理Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_給付実績Ｆ_媒体区分
     */
    国保連取込媒体_給付実績Ｆ_媒体区分("国保連取込媒体_給付実績Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_給付実績結果Ｆ_媒体区分
     */
    国保連取込媒体_給付実績結果Ｆ_媒体区分("国保連取込媒体_給付実績結果Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_共同更新Ｆ_媒体区分
     */
    国保連取込媒体_共同更新Ｆ_媒体区分("国保連取込媒体_共同更新Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_共同受給Ｆ_媒体区分
     */
    国保連取込媒体_共同受給Ｆ_媒体区分("国保連取込媒体_共同受給Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_公費一覧Ｆ_媒体区分
     */
    国保連取込媒体_公費一覧Ｆ_媒体区分("国保連取込媒体_公費一覧Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_高額決定者Ｆ_媒体区分
     */
    国保連取込媒体_高額決定者Ｆ_媒体区分("国保連取込媒体_高額決定者Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_高額対象者Ｆ_媒体区分
     */
    国保連取込媒体_高額対象者Ｆ_媒体区分("国保連取込媒体_高額対象者Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_再審決定Ｆ_媒体区分
     */
    国保連取込媒体_再審決定Ｆ_媒体区分("国保連取込媒体_再審決定Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_再審決定公費Ｆ_媒体区分
     */
    国保連取込媒体_再審決定公費Ｆ_媒体区分("国保連取込媒体_再審決定公費Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_受給更新Ｆ_媒体区分
     */
    国保連取込媒体_受給更新Ｆ_媒体区分("国保連取込媒体_受給更新Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_受給台帳Ｆ_媒体区分
     */
    国保連取込媒体_受給台帳Ｆ_媒体区分("国保連取込媒体_受給台帳Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_受給突合結果Ｆ_媒体区分
     */
    国保連取込媒体_受給突合結果Ｆ_媒体区分("国保連取込媒体_受給突合結果Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_償還支給Ｆ_媒体区分
     */
    国保連取込媒体_償還支給Ｆ_媒体区分("国保連取込媒体_償還支給Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_償還不支給Ｆ_媒体区分
     */
    国保連取込媒体_償還不支給Ｆ_媒体区分("国保連取込媒体_償還不支給Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_審査請求Ｆ_媒体区分
     */
    国保連取込媒体_審査請求Ｆ_媒体区分("国保連取込媒体_審査請求Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_請求通知Ｆ_媒体区分
     */
    国保連取込媒体_請求通知Ｆ_媒体区分("国保連取込媒体_請求通知Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_請求通知公費Ｆ_媒体区分
     */
    国保連取込媒体_請求通知公費Ｆ_媒体区分("国保連取込媒体_請求通知公費Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_自己負担確認Ｆ_媒体区分
     */
    国保連取込媒体_自己負担確認Ｆ_媒体区分("国保連取込媒体_自己負担確認Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_自己負担証明Ｆ_媒体区分
     */
    国保連取込媒体_自己負担証明Ｆ_媒体区分("国保連取込媒体_自己負担証明Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_支給計算結果Ｆ_媒体区分
     */
    国保連取込媒体_支給計算結果Ｆ_媒体区分("国保連取込媒体_支給計算結果Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_合算支給通知Ｆ_媒体区分
     */
    国保連取込媒体_合算支給通知Ｆ_媒体区分("国保連取込媒体_合算支給通知Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_合算支給一覧Ｆ_媒体区分
     */
    国保連取込媒体_合算支給一覧Ｆ_媒体区分("国保連取込媒体_合算支給一覧Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_合算給付実績Ｆ_媒体区分
     */
    国保連取込媒体_合算給付実績Ｆ_媒体区分("国保連取込媒体_合算給付実績Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_過誤決定総合Ｆ_媒体区分
     */
    国保連取込媒体_過誤決定総合Ｆ_媒体区分("国保連取込媒体_過誤決定総合Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_請求通知総合Ｆ_媒体区分
     */
    国保連取込媒体_請求通知総合Ｆ_媒体区分("国保連取込媒体_請求通知総合Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_審査請求総合Ｆ_媒体区分
     */
    国保連取込媒体_審査請求総合Ｆ_媒体区分("国保連取込媒体_審査請求総合Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_過誤申立Ｆ_ファイル名称
     */
    国保連送付媒体_過誤申立Ｆ_ファイル名称("国保連送付媒体_過誤申立Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_給付管理票Ｆ_ファイル名称
     */
    国保連送付媒体_給付管理票Ｆ_ファイル名称("国保連送付媒体_給付管理票Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_給付実績Ｆ_ファイル名称
     */
    国保連送付媒体_給付実績Ｆ_ファイル名称("国保連送付媒体_給付実績Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_共同異動Ｆ_ファイル名称
     */
    国保連送付媒体_共同異動Ｆ_ファイル名称("国保連送付媒体_共同異動Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_高額判定Ｆ_ファイル名称
     */
    国保連送付媒体_高額判定Ｆ_ファイル名称("国保連送付媒体_高額判定Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_再審申立Ｆ_ファイル名称
     */
    国保連送付媒体_再審申立Ｆ_ファイル名称("国保連送付媒体_再審申立Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_受給異動Ｆ_ファイル名称
     */
    国保連送付媒体_受給異動Ｆ_ファイル名称("国保連送付媒体_受給異動Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_受給突合Ｆ_ファイル名称
     */
    国保連送付媒体_受給突合Ｆ_ファイル名称("国保連送付媒体_受給突合Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_償還Ｆ_ファイル名称
     */
    国保連送付媒体_償還Ｆ_ファイル名称("国保連送付媒体_償還Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_支給申請Ｆ_ファイル名称
     */
    国保連送付媒体_支給申請Ｆ_ファイル名称("国保連送付媒体_支給申請Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_補正自己負担Ｆ_ファイル名称
     */
    国保連送付媒体_補正自己負担Ｆ_ファイル名称("国保連送付媒体_補正自己負担Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_計算結果連絡Ｆ_ファイル名称
     */
    国保連送付媒体_計算結果連絡Ｆ_ファイル名称("国保連送付媒体_計算結果連絡Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_合算給付実績Ｆ_ファイル名称
     */
    国保連送付媒体_合算給付実績Ｆ_ファイル名称("国保連送付媒体_合算給付実績Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_過誤申立総合Ｆ_ファイル名称
     */
    国保連送付媒体_過誤申立総合Ｆ_ファイル名称("国保連送付媒体_過誤申立総合Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_受給訂正Ｆ_ファイル名称
     */
    国保連送付媒体_受給訂正Ｆ_ファイル名称("国保連送付媒体_受給訂正Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_過誤申立Ｆ_媒体区分
     */
    国保連送付媒体_過誤申立Ｆ_媒体区分("国保連送付媒体_過誤申立Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_給付管理票Ｆ_媒体区分
     */
    国保連送付媒体_給付管理票Ｆ_媒体区分("国保連送付媒体_給付管理票Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_給付実績Ｆ_媒体区分
     */
    国保連送付媒体_給付実績Ｆ_媒体区分("国保連送付媒体_給付実績Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_共同異動Ｆ_媒体区分
     */
    国保連送付媒体_共同異動Ｆ_媒体区分("国保連送付媒体_共同異動Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_高額判定Ｆ_媒体区分
     */
    国保連送付媒体_高額判定Ｆ_媒体区分("国保連送付媒体_高額判定Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_再審申立Ｆ_媒体区分
     */
    国保連送付媒体_再審申立Ｆ_媒体区分("国保連送付媒体_再審申立Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_受給異動Ｆ_媒体区分
     */
    国保連送付媒体_受給異動Ｆ_媒体区分("国保連送付媒体_受給異動Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_受給突合Ｆ_媒体区分
     */
    国保連送付媒体_受給突合Ｆ_媒体区分("国保連送付媒体_受給突合Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_償還Ｆ_媒体区分
     */
    国保連送付媒体_償還Ｆ_媒体区分("国保連送付媒体_償還Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_支給申請Ｆ_媒体区分
     */
    国保連送付媒体_支給申請Ｆ_媒体区分("国保連送付媒体_支給申請Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_補正自己負担Ｆ_媒体区分
     */
    国保連送付媒体_補正自己負担Ｆ_媒体区分("国保連送付媒体_補正自己負担Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_計算結果連絡Ｆ_媒体区分
     */
    国保連送付媒体_計算結果連絡Ｆ_媒体区分("国保連送付媒体_計算結果連絡Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_合算給付実績Ｆ_媒体区分
     */
    国保連送付媒体_合算給付実績Ｆ_媒体区分("国保連送付媒体_合算給付実績Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_過誤申立総合Ｆ_媒体区分
     */
    国保連送付媒体_過誤申立総合Ｆ_媒体区分("国保連送付媒体_過誤申立総合Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_受給訂正Ｆ_媒体区分
     */
    国保連送付媒体_受給訂正Ｆ_媒体区分("国保連送付媒体_受給訂正Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名("国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名("国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名("国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名("国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名("国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名("国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名("国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名("国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名("国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名("国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名("国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名("国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名("国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名("国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名("国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名"),
    /**
     * 初期表示_高額サービス費申請登録初期
     */
    初期表示_高額サービス費申請登録初期("初期表示_高額サービス費申請登録初期"),
    /**
     * 初期表示_事業高額サービス費申請登録初期
     */
    初期表示_事業高額サービス費申請登録初期("初期表示_事業高額サービス費申請登録初期"),
    /**
     * 高額合算自己負担額補正_支払場所
     */
    高額合算自己負担額補正_支払場所("高額合算自己負担額補正_支払場所"),
    /**
     * 利用者負担割合判定管理_年度終了月日
     */
    利用者負担割合判定管理_年度終了月日("利用者負担割合判定管理_年度終了月日"),
    /**
     * 高額自動償還_初回申請把握基準日
     */
    高額自動償還_初回申請把握基準日("高額自動償還_初回申請把握基準日"),
    /**
     * 高額自動償還_死亡者制御
     */
    高額自動償還_死亡者制御("高額自動償還_死亡者制御"),
    /**
     * 過誤取下げ再請求指示_同月審査区分
     */
    過誤取下げ再請求指示_同月審査区分("過誤取下げ再請求指示_同月審査区分"),
    /**
     * 国保連送付媒体_過誤申立総合経措Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_過誤申立総合経措Ｆ_外部ＣＳＶファイル名("国保連送付媒体_過誤申立総合経措Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付_共同処理用受給者異動情報_処理サイクル区分
     */
    国保連送付_共同処理用受給者異動情報_処理サイクル区分("国保連送付_共同処理用受給者異動情報_処理サイクル区分"),
    /**
     * 国保_後期高齢ＩＦ_国保ＩＦ種類
     */
    国保_後期高齢ＩＦ_国保ＩＦ種類("国保_後期高齢ＩＦ_国保ＩＦ種類"),
    /**
     * 国保_後期高齢ＩＦ_後期ＩＦ種類
     */
    国保_後期高齢ＩＦ_後期ＩＦ種類("国保_後期高齢ＩＦ_後期ＩＦ種類"),
    /**
     * 国保連送付外字_変換区分
     */
    国保連送付外字_変換区分("国保連送付外字_変換区分"),
    /**
     * 国保連送付_受給者異動連絡票情報_処理サイクル区分
     */
    国保連送付_受給者異動連絡票情報_処理サイクル区分("国保連送付_受給者異動連絡票情報_処理サイクル区分"),
    /**
     * 事業高額決定通知書_取り消し線
     */
    事業高額決定通知書_取り消し線("事業高額決定通知書_取り消し線"),
    /**
     * 事業高額決定通知書_DF6101
     */
    事業高額決定通知書_DF6101("事業高額決定通知書_DF6101"),
    /**
     * 事業高額決定通知書_口座マスク
     */
    事業高額決定通知書_口座マスク("事業高額決定通知書_口座マスク"),
    /**
     * 事業高額決定通知書_支払予定日印字有無
     */
    事業高額決定通知書_支払予定日印字有無("事業高額決定通知書_支払予定日印字有無"),
    /**
     * 事業高額決定通知書_窓口項目見出し制御
     */
    事業高額決定通知書_窓口項目見出し制御("事業高額決定通知書_窓口項目見出し制御"),
    /**
     * 事業分高額合算支給額計算_給付の種類
     */
    事業分高額合算支給額計算_給付の種類("事業分高額合算支給額計算_給付の種類"),
    /**
     * 事業分高額合算支給額計算_不支給理由
     */
    事業分高額合算支給額計算_不支給理由("事業分高額合算支給額計算_不支給理由"),
    /**
     * 事業分高額合算支給額計算_支払方法
     */
    事業分高額合算支給額計算_支払方法("事業分高額合算支給額計算_支払方法"),
    /**
     * 事業高額決定通知書_帳票文言様式
     */
    事業高額決定通知書_帳票文言様式("事業高額決定通知書_帳票文言様式"),
    /**
     * 支給決定情報補正_給付の種類_事業分
     */
    支給決定情報補正_給付の種類_事業分("支給決定情報補正_給付の種類_事業分"),
    /**
     * 支給決定情報補正_給付の種類_要介護
     */
    支給決定情報補正_給付の種類_要介護("支給決定情報補正_給付の種類_要介護"),
    /**
     * 支給決定情報補正_給付の種類_要支援
     */
    支給決定情報補正_給付の種類_要支援("支給決定情報補正_給付の種類_要支援"),
    /**
     * 取引金融機関情報_振込単位
     */
    取引金融機関情報_振込単位("取引金融機関情報_振込単位"),
    /**
     * 国保連送付媒体_過誤申立総合経措Ｆ_媒体区分
     */
    国保連送付媒体_過誤申立総合経措Ｆ_媒体区分("国保連送付媒体_過誤申立総合経措Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_サービスコード異動連絡票Ｆ_媒体区分
     */
    国保連送付媒体_サービスコード異動連絡票Ｆ_媒体区分("国保連送付媒体_サービスコード異動連絡票Ｆ_媒体区分"),
    /**
     * 国保連高額合算運用_後期国保個別処理開始年月
     */
    国保連高額合算運用_後期国保個別処理開始年月("国保連高額合算運用_後期国保個別処理開始年月"),
    /**
     * 減免前後課税区分
     */
    減免前後課税区分("減免前後課税区分"),
    /**
     * 名寄せ
     */
    名寄せ("名寄せ"),
    /**
     * 高額合算自己負担額計算_抽出対象自己負担基準額です。
     */
    高額合算自己負担額計算_抽出対象自己負担基準額("高額合算自己負担額計算_抽出対象自己負担基準額"),
    /**
     * 介護住宅改修理由書作成単価です。
     */
    介護住宅改修理由書作成単価("介護住宅改修理由書作成単価"),
    /**
     * 事業分高額合算支給額計算_抽出対象支給基準額です。
     */
    事業分高額合算支給額計算_抽出対象支給基準額("事業分高額合算支給額計算_抽出対象支給基準額"),
    /**
     * 高額自己負担上限額_15000
     */
    高額自己負担上限額_15000("高額自己負担上限額_15000"),
    /**
     * 高額自己負担上限額_24600
     */
    高額自己負担上限額_24600("高額自己負担上限額_24600"),
    /**
     * 高額自己負担上限額_37200
     */
    高額自己負担上限額_37200("高額自己負担上限額_37200"),
    /**
     * 高額自己負担上限額_44000
     */
    高額自己負担上限額_44000("高額自己負担上限額_44000"),
    /**
     * 高額自己負担上限額_44400
     */
    高額自己負担上限額_44400("高額自己負担上限額_44400"),
    /**
     * 国保連送付媒体_サービスコード異動連絡票Ｆ_外部ＣＳＶファイル名です。
     */
    国保連送付媒体_サービスコード異動連絡票Ｆ_外部ＣＳＶファイル名("国保連送付媒体_サービスコード異動連絡票Ｆ_外部ＣＳＶファイル名"),
    /**
     * 高額対象者抽出再計算_年月範囲。
     */
    高額対象者抽出再計算_年月範囲("高額対象者抽出再計算_年月範囲"),
    /**
     * 国保連受給異動_計画終了日＊
     */
    国保連受給異動_計画終了日_星("国保連受給異動_計画終了日＊"),
    /**
     * 振込単位
     */
    振込単位("振込単位");

    private final RString fullName;

    private ConfigNameDBC(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBC)の名称を返します。
     *
     * @return コンフィグ名称(DBC)の名称
     */
    public RString get名称() {
        return fullName;
    }

}
